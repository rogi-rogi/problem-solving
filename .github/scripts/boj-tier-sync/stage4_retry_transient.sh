#!/usr/bin/env bash
set -euo pipefail

DEST_ROOT="baekjoon-online-judge"
tiers=("unrank" "bronze" "silver" "gold" "platinum" "diamond")
state_dir="$DEST_ROOT/_sync_state"

transient_in="$state_dir/transient_failed_pids.this_run.txt"
logical_extra="$state_dir/logical_failures.retry_extra.tsv"
: > "$logical_extra"

if [ ! -s "$transient_in" ]; then
  echo "No transient failures to retry."
  exit 0
fi

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

lookup_levels_strong_chunk() {
  local -a request_pids=("$@")

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
  for attempt in 1 2 3 4 5 6; do
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

    if [ "$http" = "429" ]; then
      sleep 60
      continue
    fi

    if [[ "$http" =~ ^5 ]] || [ "$http" = "000" ]; then
      sleep_sec=$((5 * (2 ** (attempt-1))))
      if [ "$sleep_sec" -gt 60 ]; then sleep_sec=60; fi
      sleep "$sleep_sec"
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

mapfile -t transient_pids < "$transient_in"

declare -A seen_norm=()
declare -a request_pids=()
for pid in "${transient_pids[@]}"; do
  [ -z "$pid" ] && continue
  norm="$((10#$pid))"
  if [ -z "${seen_norm[$norm]+x}" ]; then
    seen_norm[$norm]=1
    request_pids+=("$pid")
  fi
done

CHUNK_SIZE=100
for ((start=0; start<${#request_pids[@]}; start+=CHUNK_SIZE)); do
  chunk=("${request_pids[@]:start:CHUNK_SIZE}")
  lookup_levels_strong_chunk "${chunk[@]}"
done

for pid in "${transient_pids[@]}"; do
  [ -z "$pid" ] && continue

  norm="$((10#$pid))"
  status="${LOOKUP_STATUS_BY_NORM[$norm]:-LOGIC}"
  reason="${LOOKUP_REASON_BY_NORM[$norm]:-UNKNOWN}"

  case "$status" in
    OK)
      level="${LOOKUP_LEVEL_BY_NORM[$norm]:-}"
      curr_tier="$(map_level_to_tier "$level")"
      if [ -z "$curr_tier" ]; then
        echo -e "$pid\t\t\tOUT_OF_RANGE_LEVEL_$level" >> "$logical_extra"
        continue
      fi

      found_any=0
      for t in "${tiers[@]}"; do
        while IFS= read -r -d '' f; do
          found_any=1
          base="$(basename "$f")"
          prev_tier="$(basename "$(dirname "$f")")"

          if [ "$prev_tier" = "$curr_tier" ]; then
            continue
          fi

          dest="$DEST_ROOT/$curr_tier/$base"
          if [ -e "$dest" ]; then
            echo -e "$pid\t$f\t$prev_tier\tDEST_EXISTS:$dest" >> "$logical_extra"
            continue
          fi

          git mv "$f" "$dest"
        done < <(find "$DEST_ROOT/$t" -maxdepth 1 -type f -name "${pid}.*" -print0 2>/dev/null || true)
      done

      if [ "$found_any" -eq 0 ]; then
        echo -e "$pid\t\t\tPID_FILE_NOT_FOUND_AFTER_RETRY" >> "$logical_extra"
      fi
      ;;
    LOGIC)
      echo -e "$pid\t\t\t$reason" >> "$logical_extra"
      ;;
    TRANSIENT)
      http="$reason"
      echo -e "$pid\t\t\tRETRY_TRANSIENT_HTTP_$http" >> "$logical_extra"
      ;;
    *)
      echo -e "$pid\t\t\tRETRY_UNKNOWN_RESULT" >> "$logical_extra"
      ;;
  esac
done
