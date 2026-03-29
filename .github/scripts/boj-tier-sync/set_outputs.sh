#!/usr/bin/env bash
set -euo pipefail

DEST_ROOT="baekjoon-online-judge"
state_dir="$DEST_ROOT/_sync_state"

transient_cnt="$(wc -l < "$state_dir/transient_failed_pids.this_run.txt" 2>/dev/null || echo 0)"
logical_cnt="$(wc -l < "$state_dir/logical_failures.this_run.tsv" 2>/dev/null || echo 0)"

echo "transient_count=$transient_cnt" >> "$GITHUB_OUTPUT"
echo "logical_count=$logical_cnt" >> "$GITHUB_OUTPUT"
