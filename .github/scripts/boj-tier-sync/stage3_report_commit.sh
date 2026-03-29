#!/usr/bin/env bash
set -euo pipefail

DEST_ROOT="baekjoon-online-judge"
state_dir="$DEST_ROOT/_sync_state"

scanned="$(cat "$state_dir/scanned_count.this_run.txt" || echo 0)"
transient_cnt="$(wc -l < "$state_dir/transient_failed_pids.this_run.txt" || echo 0)"
logical_cnt="$(wc -l < "$state_dir/logical_failures.this_run.tsv" || echo 0)"
moved_cnt="$(wc -l < "$state_dir/moved.this_run.tsv" || echo 0)"

ts="$(date -u +%Y%m%dT%H%M%SZ)"
report="$state_dir/run_reports/report_$ts.md"

{
  echo "# BOJ Tier Sync Report ($ts UTC)"
  echo
  echo "- Scanned files: $scanned"
  echo "- Moved files: $moved_cnt"
  echo "- Transient failures (429/5xx/network): $transient_cnt"
  echo "- Logical failures: $logical_cnt"
  echo
  echo "## Transient failed PIDs"
  if [ "$transient_cnt" -gt 0 ]; then
    sed 's/^/- /' "$state_dir/transient_failed_pids.this_run.txt"
  else
    echo "- (none)"
  fi
  echo
  echo "## Logical failures (pid, path, prev_tier, reason)"
  if [ "$logical_cnt" -gt 0 ]; then
    echo '```'
    cat "$state_dir/logical_failures.this_run.tsv"
    echo '```'
  else
    echo "(none)"
  fi
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
