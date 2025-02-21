// https://school.programmers.co.kr/learn/courses/30/lessons/42584
// 주식가격.java

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        final int N = prices.length;
        
        int[] res = new int[N];
        for (int i = 0; i < N; ++i) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                final int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            final int idx = stack.pop();
            res[idx] = N - 1 - idx;
        }
        
        return res;
    }
}
