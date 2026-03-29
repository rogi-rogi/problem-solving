#!/usr/bin/env bash
set -euo pipefail

DEST_ROOT="baekjoon-online-judge"
tiers=("unrank" "bronze" "silver" "gold" "platinum" "diamond")

BATCH_SIZE=100
BASE_COOLDOWN_SEC=1
cooldown_sec="$BASE_COOLDOWN_SEC"
PER_REQUEST_DELAY_SEC="0.05"
RETRY_MAX=2
RETRY_SLEEP_SEC=2

state_dir="$DEST_ROOT/_sync_state"
transient_file="$state_dir/transient_failed_pids.this_run.txt"
logical_file="$state_dir/logical_failures.this_run.tsv"
moved_file="$state_dir/moved.this_run.tsv"

: > "$transient_file"
: > "$logical_file"
: > "$moved_file"

declare -a all_files=()
for t in "${tiers[@]}"; do
  while IFS= read -r -d '' f; do
    all_files+=("$f")
  done < <(find "$DEST_ROOT/$t" -maxdepth 1 -type f -print0 || true)
done

total=${#all_files[@]}
if [ "$total" -eq 0 ]; then
  echo "No files found."
  echo "0" > "$state_dir/scanned_count.this_run.txt"
  exit 0
fi

echo "Total files: $total"
echo "Batch size: $BATCH_SIZE"
echo "Cooldown base: ${BASE_COOLDOWN_SEC}s (non-decreasing, +60s if batch fail rate >= 10%)"
echo "Format: [global_idx/total] [batch_idx/batch_total] pid | prev -> curr | action"
echo "---------------------------------------------------------"

map_level_to_tier() {
  local level="$1"
  if   [ "$level" -eq 0  ]; then echo "unrank"
  elif [ "$level" -ge 1  ] && [ "$level" -le 5  ]; then echo "bronze"
  elif [ "$level" -le 10 ]; then echo "silver"
  elif [ "$level" -le 15 ]; then echo "gold"
  elif [ "$level" -le 20 ]; then echo "platinum"
  elif [ "$level" -le 25 ]; then echo "diamond"
  else echo ""
  fi
}

declare -A LOOKUP_STATUS_BY_NORM=()
declare -A LOOKUP_REASON_BY_NORM=()
declare -A LOOKUP_LEVEL_BY_NORM=()

lookup_levels_batch() {
  local -a request_pids=("$@")
  LOOKUP_STATUS_BY_NORM=()
  LOOKUP_REASON_BY_NORM=()
  LOOKUP_LEVEL_BY_NORM=()

  local joined=""
  local pid
  for pid in "${request_pids[@]}"; do
    joined+="${pid}%2C"
  done
  joined="${joined%%%2C}"

  local url="https://solved.ac/api/v3/problem/lookup?problemIds=${joined}"
  local tmp
  tmp="$(mktemp)"

  local http="000"
  local attempt
  for attempt in $(seq 1 "$RETRY_MAX"); do
    http="$(curl -sS -L -H "User-Agent: BOJ-Tier-Sync" -o "$tmp" -w "%{http_code}" "$url" || echo "000")"

    if [ "$http" = "200" ]; then
      while IFS=$'\t' read -r problem_id level; do
        [ -z "$problem_id" ] && continue
        LOOKUP_LEVEL_BY_NORM["$problem_id"]="$level"
      done < <(jq -r '.[] | "\(.problemId)\t\(.level // "")"' "$tmp")

      rm -f "$tmp"

      for pid in "${request_pids[@]}"; do
        local norm
        norm="$((10#$pid))"
        local level_val
        level_val="${LOOKUP_LEVEL_BY_NORM[$norm]:-}"
        if [ -n "$level_val" ]; then
          LOOKUP_STATUS_BY_NORM["$norm"]="OK"
        else
          LOOKUP_STATUS_BY_NORM["$norm"]="LOGIC"
          LOOKUP_REASON_BY_NORM["$norm"]="NO_LEVEL"
        fi
      done
      return 0
    fi

    if [ "$http" = "429" ] || [[ "$http" =~ ^5 ]] || [ "$http" = "000" ]; then
      if [ "$attempt" -lt "$RETRY_MAX" ]; then
        sleep "$RETRY_SLEEP_SEC"
      fi
      continue
    fi

    rm -f "$tmp"
    for pid in "${request_pids[@]}"; do
      local norm
      norm="$((10#$pid))"
      LOOKUP_STATUS_BY_NORM["$norm"]="LOGIC"
      LOOKUP_REASON_BY_NORM["$norm"]="HTTP_$http"
    done
    return 0
  done

  rm -f "$tmp"
  for pid in "${request_pids[@]}"; do
    local norm
    norm="$((10#$pid))"
    LOOKUP_STATUS_BY_NORM["$norm"]="TRANSIENT"
    LOOKUP_REASON_BY_NORM["$norm"]="$http"
  done
  return 0
}

checked_total=0
batch_start=0
batch_no=0

while [ "$batch_start" -lt "$total" ]; do
  batch_no=$((batch_no+1))

  batch_end=$((batch_start + BATCH_SIZE))
  if [ "$batch_end" -gt "$total" ]; then
    batch_end="$total"
  fi
  batch_count=$((batch_end - batch_start))

  batch_transient=0
  batch_logical=0

  echo "================ Batch #$batch_no ($batch_count files) ================"
  echo "Current cooldown: ${cooldown_sec}s"

  checked_batch=0

  declare -a valid_files=()
  declare -a valid_bases=()
  declare -a valid_prev=()
  declare -a valid_pids=()
  declare -a valid_disp_total=()
  declare -a valid_disp_batch=()

  for ((i=batch_start; i<batch_end; i++)); do
    f="${all_files[$i]}"
    base="$(basename "$f")"
    prev_tier="$(basename "$(dirname "$f")")"

    checked_total=$((checked_total+1))
    checked_batch=$((checked_batch+1))

    if [[ ! "$base" =~ ^([0-9]{5})\..+ ]]; then
      echo "[$checked_total/$total] [$checked_batch/$batch_count] ----- | $prev_tier -> ----- | skip (invalid filename)"
      printf "%s\t%s\t%s\t%s\n" "-----" "$f" "$prev_tier" "INVALID_FILENAME" >> "$logical_file"
      batch_logical=$((batch_logical+1))
      continue
    fi

    pid="${BASH_REMATCH[1]}"
    valid_files+=("$f")
    valid_bases+=("$base")
    valid_prev+=("$prev_tier")
    valid_pids+=("$pid")
    valid_disp_total+=("$checked_total")
    valid_disp_batch+=("$checked_batch")
  done

  if [ "${#valid_pids[@]}" -gt 0 ]; then
    declare -A seen_norm=()
    declare -a request_pids=()

    for pid in "${valid_pids[@]}"; do
      norm="$((10#$pid))"
      if [ -z "${seen_norm[$norm]+x}" ]; then
        seen_norm[$norm]=1
        request_pids+=("$pid")
      fi
    done

    lookup_levels_batch "${request_pids[@]}"

    for ((j=0; j<${#valid_pids[@]}; j++)); do
      f="${valid_files[$j]}"
      base="${valid_bases[$j]}"
      prev_tier="${valid_prev[$j]}"
      pid="${valid_pids[$j]}"
      disp_total="${valid_disp_total[$j]}"
      disp_batch="${valid_disp_batch[$j]}"
      norm="$((10#$pid))"

      status="${LOOKUP_STATUS_BY_NORM[$norm]:-LOGIC}"
      reason="${LOOKUP_REASON_BY_NORM[$norm]:-UNKNOWN}"

      case "$status" in
        OK)
          level="${LOOKUP_LEVEL_BY_NORM[$norm]:-}"
          curr_tier="$(map_level_to_tier "$level")"
          if [ -z "$curr_tier" ]; then
            echo "[$disp_total/$total] [$disp_batch/$batch_count] $pid | $prev_tier -> (level=$level) | skip (out of range)"
            printf "%s\t%s\t%s\t%s\n" "$pid" "$f" "$prev_tier" "OUT_OF_RANGE_LEVEL_$level" >> "$logical_file"
            batch_logical=$((batch_logical+1))
            continue
          fi

          if [ "$curr_tier" = "$prev_tier" ]; then
            echo "[$disp_total/$total] [$disp_batch/$batch_count] $pid | $prev_tier -> $curr_tier | keep"
            continue
          fi

          dest="$DEST_ROOT/$curr_tier/$base"
          if [ -e "$dest" ]; then
            echo "[$disp_total/$total] [$disp_batch/$batch_count] $pid | $prev_tier -> $curr_tier | skip (dest exists)"
            printf "%s\t%s\t%s\t%s\n" "$pid" "$f" "$prev_tier" "DEST_EXISTS:$dest" >> "$logical_file"
            batch_logical=$((batch_logical+1))
            continue
          fi

          echo "[$disp_total/$total] [$disp_batch/$batch_count] $pid | $prev_tier -> $curr_tier | move"
          git mv "$f" "$dest"
          printf "%s\t%s\t%s\t%s\n" "$pid" "$f" "$prev_tier" "$curr_tier" >> "$moved_file"
          ;;
        TRANSIENT)
          http="$reason"
          echo "[$disp_total/$total] [$disp_batch/$batch_count] $pid | $prev_tier -> ----- | transient_fail (http=$http)"
          echo "$pid" >> "$transient_file"
          batch_transient=$((batch_transient+1))
          ;;
        LOGIC|*)
          echo "[$disp_total/$total] [$disp_batch/$batch_count] $pid | $prev_tier -> ----- | logical_fail ($reason)"
          printf "%s\t%s\t%s\t%s\n" "$pid" "$f" "$prev_tier" "$reason" >> "$logical_file"
          batch_logical=$((batch_logical+1))
          ;;
      esac

      sleep "$PER_REQUEST_DELAY_SEC"
    done
  fi

  batch_fail=$((batch_transient + batch_logical))
  if [ $((batch_fail * 100)) -ge $((batch_count * 10)) ]; then
    cooldown_sec=$((cooldown_sec + 60))
    echo "Batch failure rate >= 10% (fail=$batch_fail/$batch_count). Cooldown increased to ${cooldown_sec}s"
  else
    echo "Batch failure rate < 10% (fail=$batch_fail/$batch_count). Cooldown stays ${cooldown_sec}s"
  fi

  batch_start="$batch_end"

  if [ "$batch_start" -lt "$total" ]; then
    echo "Cooldown ${cooldown_sec}s before next batch..."
    sleep "$cooldown_sec"
  fi
done

echo "$checked_total" > "$state_dir/scanned_count.this_run.txt"
sort -u "$transient_file" -o "$transient_file" || true
