// https://school.programmers.co.kr/learn/courses/30/lessons/42587
// 프로세스.java

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; ++i) {
            queue.add(new int[]{priorities[i], i});
        }
        Arrays.sort(priorities);
        int idx = priorities.length - 1, cnt = 0;
        while (true) {
            int[] e = queue.poll();
            if (e[0] < priorities[idx]) {
                queue.add(e);
            } else {
                ++cnt;
                --idx;
                if (e[1] == location)
                    break;
            }
        }
        return cnt;
    }
}
