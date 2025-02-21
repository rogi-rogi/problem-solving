// https://school.programmers.co.kr/learn/courses/30/lessons/12906
// 같은 숫자는 싫어.java

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>(List.of(arr[0]));
        for (int i = 1; i < arr.length; ++i) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; --i) {
            res[i] = stack.pop();
        }
        return res;
    }
}
