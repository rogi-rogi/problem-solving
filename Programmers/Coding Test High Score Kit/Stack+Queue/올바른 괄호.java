// https://school.programmers.co.kr/learn/courses/30/lessons/12909
// 올바른 괄호.java

import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (char chr : s.toCharArray()) {
            if (chr == '(') {
                stack.push(1);
            } else {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
