# solved.ac 문제 난이도 수집 가이드

이 문서는 solved.ac API를 이용해 BOJ(백준) 문제 난이도(level)를 수집하고, 이를 기반으로 폴더(브론즈/실버/골드/플래티넘 …)로 자동 분류하는 방법을 정리합니다.

### 동작 흐름
- GitHub Actions를 활용해 다음 작업을 자동(매월 1일)으로 수행한다.
- 문제 번호(pid)를 기반으로 solved.ac에서 문제 메타데이터를 조회한다. 
- 조회된 level 값을 바탕으로 분류할 문제의 난이도 티어 폴더를 결정한다. 
- 기존 파일을 티어 폴더로 이동(동기화)한다. 

<br/>

## API 엔드포인트

### 요청
```
GET https://solved.ac/api/v3/search/suggestion?query=${pid}
```
- pid: 백준 문제 번호 (예: 1000)

### 응답 구조

```json
{
  "autocomplete": [
    {
      "caption": "1000",
      "description": ""
    }
  ],
  "problems": [
    {
      "id": 1000,
      "title": "A+B",
      "level": 1,
      "solved": 363217,
      "caption": "A+B",
      "description": "#1000",
      "href": "https://www.acmicpc.net/problem/1000"
    }
  ]
}
```

### problems 배열 값 설명

- problems[].id : 문제 번호
- problems[].title : 문제 제목
- problems[].level : solved.ac 난이도 레벨 (정수)
- problems[].href : 백준 문제 링크

일반적으로 query에 문제 번호를 넣으면 problems의 첫번째 요소가 해당 문제에 대한 메타데이터입니다.
다만 방어적으로는 problems 배열에서 id === pid 인 항목을 찾아 쓰는 걸 권장합니다.

<br/>

# 티어 폴더 분류 규칙

> 현재 분류 방식: level을 5로 나눈 몫(quotient) 을 기준으로 폴더를 결정한다.

### 분류 예시 (설명용)
```
level = 1 → 1 / 5 = 0.xxx → 몫 0 → bronze
level = 7 → 7 / 5 = 1.xxx → 몫 1 → silver
level = 14 → 14 / 5 = 2.xxx → 몫 2 → gold
```

<br/>

## GitHub Actions 스크립트

[스크립트 보기](../.github/workflows/sync-solvedac.yml)