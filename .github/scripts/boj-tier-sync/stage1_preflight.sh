#!/usr/bin/env bash
set -euo pipefail

if ! command -v jq >/dev/null 2>&1; then
  echo "jq not found on runner. (ubuntu-latest usually includes jq)"
  exit 1
fi

DEST_ROOT="baekjoon-online-judge"
tiers=("unrank" "bronze" "silver" "gold" "platinum" "diamond")

if [ ! -d "$DEST_ROOT" ]; then
  echo "Missing directory: $DEST_ROOT"
  exit 1
fi

for t in "${tiers[@]}"; do
  mkdir -p "$DEST_ROOT/$t"
done

mkdir -p "$DEST_ROOT/_sync_state/run_reports"
mkdir -p "$DEST_ROOT/manual_review"
