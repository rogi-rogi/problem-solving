#!/usr/bin/env bash
set -euo pipefail

DEST_ROOT="baekjoon-online-judge"
state_dir="$DEST_ROOT/_sync_state"

logical_main="$state_dir/logical_failures.this_run.tsv"
logical_extra="$state_dir/logical_failures.retry_extra.tsv"

manual_root="$DEST_ROOT/manual_review"
mkdir -p "$manual_root/invalid_filename"
mkdir -p "$manual_root/dest_exists"
mkdir -p "$manual_root/no_level_or_4xx"
mkdir -p "$manual_root/out_of_range"
mkdir -p "$manual_root/unknown"

move_to_manual() {
  local pid="$1"
  local path="$2"
  local prev="$3"
  local reason="$4"

  if [ -z "$path" ] || [ ! -f "$path" ]; then
    return 0
  fi

  base="$(basename "$path")"

  if [ "$reason" = "INVALID_FILENAME" ]; then
    dest="$manual_root/invalid_filename/$prev"
  elif [[ "$reason" == DEST_EXISTS:* ]]; then
    dest="$manual_root/dest_exists/$prev"
  elif [ "$reason" = "NO_LEVEL" ] || [[ "$reason" == HTTP_* ]]; then
    dest="$manual_root/no_level_or_4xx/$prev"
  elif [[ "$reason" == OUT_OF_RANGE_LEVEL_* ]]; then
    dest="$manual_root/out_of_range/$prev"
  else
    dest="$manual_root/unknown/$prev"
  fi

  mkdir -p "$dest"
  git mv "$path" "$dest/$base"
}

if [ -s "$logical_main" ]; then
  while IFS=$'\t' read -r pid path prev reason; do
    [ -z "$pid" ] && continue
    move_to_manual "$pid" "$path" "$prev" "$reason"
  done < "$logical_main"
fi

if [ -s "$logical_extra" ]; then
  while IFS=$'\t' read -r pid path prev reason; do
    if [ -n "${path:-}" ] && [ -n "${prev:-}" ] && [ -n "${reason:-}" ]; then
      move_to_manual "$pid" "$path" "$prev" "$reason"
    fi
  done < "$logical_extra"
fi

if git diff --quiet && git diff --cached --quiet; then
  echo "No changes to commit in stages 4~5."
  exit 0
fi

git add -A
git config user.name "github-actions[bot]"
git config user.email "github-actions[bot]@users.noreply.github.com"
git commit -m "chore: retry failed BOJ tier sync (stages 4~5)"
git push
