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
