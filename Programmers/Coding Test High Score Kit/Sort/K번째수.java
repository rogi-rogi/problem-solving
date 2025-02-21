// https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=java
// K번째수.java

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] res = new int[commands.length];
        int idx = 0;
        
        for (int[] cmd : commands) {
            final int i = cmd[0] - 1;
            final int j = cmd[1];
            final int k = cmd[2] - 1;
            int[] subArr = Arrays.copyOfRange(array, i, j);
            Arrays.sort(subArr);
            res[idx++] = subArr[k];
        }
        return res;
    }
}
