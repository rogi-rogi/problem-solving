// https://school.programmers.co.kr/learn/courses/30/lessons/42747?language=java#
// H-Index.java

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        final int N = citations.length;
        Arrays.sort(citations);
        
        for (int i = 0; i < N; i++) {
            int H = N - i;
            if (citations[i] >= H) {
                return H;
            }
        }
        return 0;
    }
}
