# 백준 풀이 난이도 분류

GitHub Actions의 **BOJ 난이도 분류 → Run workflow**에서 작업을 선택해요.
저장소의 Actions secrets에 `SOLVED_AC_CLIENT_ID`와 `SOLVED_AC_CLIENT_SECRET`을 등록해요.

| 작업 | 입력 폴더 | 실행 시점 |
| --- | --- | --- |
| `classify-backup` | `other/solved/` | 백업을 정리할 때 수동 실행 |
| `sync` | `bronze/`부터 `diamond/`까지 다섯 난이도 폴더 | 매월 1일 오전 9시(KST) 또는 수동 실행 |

두 작업 모두 파일명에서 백준 번호를 읽고, 대상 폴더에 같은 이름이 있으면 원본을 보존하고 실패로 기록해요. 파일명과 확장자는 이동 후에도 유지해요.

## 난이도 조회

solved.ac v4 문제 목록을 ID 오름차순으로 페이지당 50문제씩 읽어요. 응답의 `judgeIds`에서 BOJ 번호가 일치하는 항목의 `level`을 사용해요. 필요한 번호를 모두 찾거나 마지막 페이지에 도달하면 종료해요. 여러 언어로 푼 같은 문제는 조회 결과 하나를 공유해요. 검색 요청 비용과 기본 충전 속도에 맞춰 페이지 사이에 1.5초를 기다리고, HTTP 429는 `Retry-After`를 따라 재시도해요. [공식 API 명세](https://backstage.solved.ac/api/v4/openapi)

| level | 대상 폴더 |
| --- | --- |
| 0 | unrated |
| 1–5 | bronze |
| 6–10 | silver |
| 11–15 | gold |
| 16–20 | platinum |
| 21–25 | diamond |
| 26–30 | ruby |

## 정기 실행 기록

실행 요약은 GitHub Actions에서 확인할 수 있어요. 정기 동기화는 변경이 없는 날에도 [실행 보고서](./_sync_state/run_reports/)를 저장해요. 보고서에는 시작·종료 시각(UTC), 대상·이동·실패 파일 수, 문제별 이전·현재 난이도와 이동 경로, 실패 사유가 담겨요.

최초 조회는 `_sync_state/levels.json`에 문제별 기준 레벨을 기록해요. 첫 실행의 이동 내역으로 기존 폴더와 새 난이도를 확인할 수 있고, 두 번째 조회부터는 Silver III → Silver II처럼 같은 폴더 안의 난이도 변경도 기록돼요. 일부 파일이 실패하면 성공한 이동과 보고서는 커밋하고 Actions 실행은 실패로 표시해요.
