// https://school.programmers.co.kr/learn/courses/30/lessons/42898
import java.util.*;

class Solution {
    final static int MOD = (int) 1e9 + 7, BLOCK = -1;
    public int solution(int m, int n, int[][] puddles) {
        // Init
        int[][] board = new int[n + 1][m + 1];
        for (int[] p : puddles) {
            board[p[1]][p[0]] = BLOCK;
        }
        
        // Solve
        board[0][1] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (board[i][j] == BLOCK) continue;
                board[i][j] = (
                    (board[i - 1][j] != BLOCK ? board[i - 1][j] : 0)+
                    (board[i][j - 1] != BLOCK ? board[i][j - 1] : 0)
                ) % MOD;
            } 
        }
        return board[n][m];
    }
}
