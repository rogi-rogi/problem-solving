// https://school.programmers.co.kr/learn/courses/30/lessons/12906
// 같은 숫자는 싫어.java

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> queue = new ArrayDeque<>(List.of(arr[0]));
        for (int i = 1; i < arr.length; ++i) {
            if (queue.peekLast() != arr[i]) {
                queue.addLast(arr[i]);
            }
        }
        int[] res = new int[queue.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = queue.pollFirst();
        }
        return res;
    }
}
