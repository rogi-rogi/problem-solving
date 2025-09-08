# 목차

- Boyer-Moore Voting Algorithm이란?
- 핵심 개념
- 동작 원리 및 예제
- 확장
- 연습문제

---

# Boyer-Moore Voting Algorithm이란?

> 배열의 원소 중 빈도가 절반을 초과하는 원소를 선형 시간과 상수 공간으로 빠르게 탐색하는 알고리즘

- 해시맵 기반 탐색보다 메모리 효율적이다.
- 빈도가 절반을 초과하는 원소의 유무를 빠르게 판단할 수 있다.
- 빈도가 절반을 초과하는 원소가 있음을 전제로 한다.

---

# 핵심 개념

- 전체 요소 중 자신과 동일한 요소일 경우는 가상의 빈도를 증가, 다른 요소를 만났을 때는 감소시켜 최종 요소를 탐색할 수 있다.
- 만약 과반수 이상의 빈도를 가지는 요소가 없다면, Boyer-Moore Voting Algorithm의 결과는 올바르지 않다.
- 때문에 최종 후보자에 대한 실제 빈도를 측정하는 검증 로직을 추가해야 한다.

---

# 동작 원리 및 예제

### 1. 후보 선정

빈도를 측정하는 변수 `count`로 자신과 동일한 요소이면 증가, 다른 요소이면 감소를 반복한다.

만약 `count`가 0이라면 이전 `candidate`의 빈도는 과반수가 될 수 없다는 것을 의미한다.

`candidate`를 현재 요소로, `count`를 1로 초기화하자.

```java
public class BoyerMooreVoting {
	public long getCandidate(long[] arr) {
		long candidate = -1, count = 0;

		for (long a : arr) {
			if (count == 0) {
				candidate = a;
				count = 1;
			} else if (a == candidate) {
				++count;
			} else {
				--count;
			}
		}

		return candidate;
	}
}
```

### 2. 빈도 검증

과반수 이상의 빈도를 가지는 요소가 있다는 것이 전제되지 않는다면, 추가 검증 로직이 필요하다.

최종 `candidate`의 실제 빈도를 측정하고, 과반수인지 검증하자.

```java
public class BoyerMooreVoting {
	public long getCandidate(long[] arr) {
		long candidate = -1, count = 0;

		// 1. 후보 선정
		for (long a : arr) {
			if (count == 0) {
				candidate = a;
				count = 1;
			} else if (a == candidate) {
				++count;
			} else {
				--count;
			}
		}

		// 2. 빈도 검증
		int actualCount = 0;
		for (long a : arr) {
			if (a == candidate) {
				++actualCount;
			}
		}
		return actualCount > (arr.length / 2) ? candidate : -1;
	}
}
```

---

# 확장

### N/K 초과 다수 원소 탐색 (Generalized Boyer-Moore Voting)

- 빈도가 과반수, 즉 `N / 2`를 초과하는 경우에는 후보가 최대 1명만 존재한다.
- 하지만 `N / K`를 초과하는 경우에는 최대 `K - 1`명의 후보가 존재할 수 있다.
- 이를 일반화한 알고리즘이 **Misra-Gries Algorithm**이며, Boyer-Moore Voting의 확장으로 이해할 수 있다.

### 관련 알고리즘

- **Top-K Frequent Elements**: `N/K`가 아닌, "가장 자주 등장한 K개 원소" 찾기 → 힙 기반
- **Count-Min Sketch**: 대용량 스트림에서 빈도 추정

---

# 연습문제

- [1270번: 전쟁 - 땅따먹기](http://boj.ma/1270)
