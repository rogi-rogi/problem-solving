/*
dp = 1
5
dp = 2
55
5 + 5 = 10
5 - 5 = 0
5 * 5 = 25
5 / 5 = 1

dp = 3
555
5 + 10 = 15
5 - 10 = 0
5 * 10 = 50
5 / 10 = 0

5 + 0 = 5
....

*/
/*
https://school.programmers.co.kr/learn/courses/30/lessons/42895
*/
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // Init
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; ++i) {
            dp.add(new HashSet<>());
        }
        
        // Solve
        int repeatN = 0;
        for (int cur = 1; cur <= 8; ++cur) {
            repeatN = repeatN * 10 + N;
            dp.get(cur).add(repeatN);
            
            for (int i = 1; i < cur; ++i) {
                for (int a : dp.get(i)) {
                    for (int b : dp.get(cur - i)) {
                        dp.get(cur).add(a + b);
                        dp.get(cur).add(a - b);
                        dp.get(cur).add(b - a);
                        dp.get(cur).add(a * b);
                        if (b != 0)
                            dp.get(cur).add(a / b);
                        if (a != 0)
                            dp.get(cur).add(b / a);
                    }
                }
            }
            if (dp.get(cur).contains(number)) {
                return cur;
            }
        }
        return -1;
    }
}
