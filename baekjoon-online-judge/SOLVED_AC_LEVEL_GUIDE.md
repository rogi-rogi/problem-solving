# solved.ac 문제 난이도 수집 가이드

이 문서는 solved.ac API를 이용해 BOJ(백준) 문제 난이도(level)를 수집하고, 이를 기반으로 폴더(언랭크/브론즈/실버/골드/플래티넘/다이아)로 자동 분류하는 현재 동작을 정리합니다.

### 동작 흐름
- GitHub Actions를 활용해 다음 작업을 자동(매월 1일)으로 수행한다.
- 티어 폴더(`unrank`, `bronze`, `silver`, `gold`, `platinum`, `diamond`) 내 문제 파일을 스캔한다.
- 파일명에서 추출한 문제 번호(pid)들을 배치 단위로 solved.ac에 조회한다.
- 조회된 `level` 값을 바탕으로 대상 티어 폴더를 결정한다.
- 기존 파일을 티어 폴더로 이동(동기화)한다.
- 실행 결과를 `_sync_state`에 기록하고 리포트를 생성한 뒤 커밋/푸시한다.

<br/>

## API 엔드포인트

### 요청
```
GET https://solved.ac/api/v3/problem/lookup?problemIds=${pid_csv}
```
- `pid_csv`: 문제 번호를 쉼표로 연결한 문자열 (예: `1000,1001,1002`)
- 워크플로우에서는 URL 인코딩된 쉼표(`%2C`)로 배치 조회한다.

### 응답 구조

```json
[
  {
    "problemId": 1000,
    "titleKo": "A+B",
    ...
    "level": 1
    ...
  },
  ...
]
```

### 주요 필드

- `problemId`: 문제 번호
- `level`: solved.ac 난이도 레벨 (정수, 0~25)

<br/>

# 티어 폴더 분류 규칙

> 현재 분류 방식: level 구간으로 티어를 결정한다.

### 분류 기준
```
level = 0        -> unrank
level = 1 ~ 5    -> bronze
level = 6 ~ 10   -> silver
level = 11 ~ 15  -> gold
level = 16 ~ 20  -> platinum
level = 21 ~ 25  -> diamond
level >= 26
```

<br/>

## 실행 스크립트

- 워크플로우: `/.github/workflows/sync-solvedac.yml`
- Stage 1: `/.github/scripts/boj-tier-sync/stage1_preflight.sh`
- Stage 2: `/.github/scripts/boj-tier-sync/stage2_scan_move.sh`
- Stage 3: `/.github/scripts/boj-tier-sync/stage3_report_commit.sh`

### 운영 파라미터(현재 Stage 2 기준)
- 배치 크기: `100`
- 배치 간 기본 쿨다운: `1초`
- 요청 간 지연: `0.05초`
- 재시도: 최대 `2회` (재시도 간 `2초`)
- 배치 실패율이 10% 이상이면 다음 배치부터 쿨다운 `+60초`

### 결과 파일
- 이동 내역: `baekjoon-online-judge/_sync_state/moved.this_run.tsv`
- 실패 내역: `baekjoon-online-judge/_sync_state/failed.this_run.tsv`
- 스캔 수: `baekjoon-online-judge/_sync_state/scanned_count.this_run.txt`
- 실행 리포트: `baekjoon-online-judge/_sync_state/run_reports/report_<UTC_TIMESTAMP>.md`
