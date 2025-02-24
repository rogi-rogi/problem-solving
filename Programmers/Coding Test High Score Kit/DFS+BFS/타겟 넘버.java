// https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java
// 타겟 넘버.java

import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Deque<int[]> queue = new ArrayDeque<>(List.of(new int[]{numbers[0], 0}, new int[]{-numbers[0], 0}));
        
        final int N = numbers.length;
        int res = 0;
        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            final int num = c[0];
            final int idx = c[1];
            
            if (idx == N - 1 && num == target) {
                ++res;
            }
            if (idx + 1 < N) {
                queue.add(new int[]{num + numbers[idx + 1], idx + 1});
                queue.add(new int[]{num - numbers[idx + 1], idx + 1});  
            }
        }
        return res;
    }
}
