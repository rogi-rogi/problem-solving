// https://school.programmers.co.kr/learn/courses/30/lessons/388351

class Solution {
	public int solution(int[] schedules, int[][] timelogs, int startday) {
		int answer = 0;

		for (int i = 0; i < schedules.length; ++i) {
			final int m = schedules[i] % 100;
			final int max = m <= 49 ?
				schedules[i] + 10 : schedules[i] - m + 100 + (m + 10) % 60;
			int day = startday;
			boolean lazy = false;
			for (int t = 0; t < 7; ++t) {
				if (day < 6 && timelogs[i][t] > max) {
					lazy = true;
				}
				day = (day % 7) + 1;
			}
			if (!lazy) ++answer;
		}
		return answer;
	}
}