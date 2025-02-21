- -https://school.programmers.co.kr/learn/courses/30/lessons/42746#qna
-- 가장 큰 수.java

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        String res = String.join("", arr).replaceFirst("^0*", "");
        return res.isEmpty() ? "0" : res;
    }
}
