// https://school.programmers.co.kr/learn/courses/30/lessons/42586
// 기능개발.java

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int progress : progresses) {
            queue.add(progress);
        }
        List<Integer> res = new ArrayList<>();
        int day = 1, idx = 0;
        while (!queue.isEmpty()) {
            int cnt = 0;
            while (!queue.isEmpty() && queue.peek() + day * speeds[idx] >= 100) {
                queue.poll();
                ++cnt;
                ++idx;
            }
            if (cnt > 0) {
                res.add(cnt);
            }
            ++day;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
