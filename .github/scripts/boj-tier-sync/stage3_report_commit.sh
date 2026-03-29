#!/usr/bin/env bash
set -euo pipefail

DEST_ROOT="baekjoon-online-judge"
state_dir="$DEST_ROOT/_sync_state"

scanned="$(cat "$state_dir/scanned_count.this_run.txt" || echo 0)"
moved_lines="$(wc -l < "$state_dir/moved.this_run.tsv" || echo 0)"
failed_lines="$(wc -l < "$state_dir/failed.this_run.tsv" || echo 0)"
if [ "$moved_lines" -gt 0 ]; then
  moved_cnt=$((moved_lines - 1))
else
  moved_cnt=0
fi
if [ "$failed_lines" -gt 0 ]; then
  failed_cnt=$((failed_lines - 1))
else
  failed_cnt=0
fi

ts="$(date -u +%Y%m%dT%H%M%SZ)"
report="$state_dir/run_reports/report_$ts.md"

{
  echo "# BOJ Tier Sync Report ($ts UTC)"
  echo
  echo "- Scanned files: $scanned"
  echo "- Moved files: $moved_cnt"
  echo "- Failed files: $failed_cnt"
} > "$report"

if git diff --quiet && git diff --cached --quiet; then
  echo "No changes to commit."
  exit 0
fi

git add -A
git config user.name "github-actions[bot]"
git config user.email "github-actions[bot]@users.noreply.github.com"
git commit -m "chore: sync BOJ tiers (stages 1~3)"
git push
