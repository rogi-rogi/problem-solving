# 📆 Problem Solving

Daily Problem Solving Challenges

<br><hr/>

### 🧑‍💻 Profile

> [Baekjoon Online Judge](https://www.acmicpc.net/user/polygon)
>
> [Solved.ac](https://solved.ac/profile/polygon)

<br><hr/>

### 🗂️ Directory

+ Baekjoon Online Judge
  + 😁 practice
    >  PL 기본 사용법을 익히는 수준 (Bronz V ~ Silver V)
  + 😎 easy
    > 간단한 이론 또는 테크닉이 적용된 문제 (Silver IV ~ silver I)
  + 🙄 normal
    > 심화 그래프와 dp, 30분 이상의 문제 (gold V ~ gold II)
  + 🤔 hard
    > 코딩테스트 올솔브 또는 코딩 대회 수준의 문제 (gold I ~ )
  + 😡 try-try
    > 증명하지 못하거나 풀지 못한 문제, 재미로 푸는 문제
    > 
    > (unranked / minor PL)
+ Programmers
  + Coding Test High Score Kit
  + SQL high score kit
+ HackerRank
  + 🛢 SQL
+ SW Expert Academy
  + D1 ~ D8

<br><hr/>

### ⚖️ License

모든 코드의 상업목적 사용을 금지하며, 교육 목적으로만 사용할 수 있습니다.

<br><hr/>

### ⚙️ etc...

기존에 푼 문제는 [solved]()에 있으며, 분류 중 입니다.

풀이는 [블로그](https://kyr-db.tistory.com/)를 통해 확인하실 수 있습니다.



# solved.ac 프로필 값 표시

아래 값은 [solved.ac](https://solved.ac/profile/polygon) 페이지에서 가져온 값입니다:

<div id="solvedValue">로딩 중...</div>

<script>
// 즉시 실행하는 비동기 함수
(async () => {
  try {
    // solved.ac 프로필 페이지를 fetch합니다.
    const response = await fetch('https://solved.ac/profile/polygon');
    // HTML 텍스트로 변환
    const text = await response.text();
    // DOMParser를 사용해 HTML 문서로 변환
    const parser = new DOMParser();
    const doc = parser.parseFromString(text, 'text/html');
    // 지정한 CSS 선택자로 요소 찾기
    const element = doc.querySelector("#__next > div.css-xi5qma > div > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div > div > b");
    const value = element ? element.textContent.trim() : "값을 가져올 수 없음";
    // 가져온 값을 페이지에 표시
    document.getElementById('solvedValue').innerText = value;
  } catch (error) {
    console.error("오류 발생:", error);
    document.getElementById('solvedValue').innerText = "오류 발생";
  }
})();
</script>

