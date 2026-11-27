import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static int[][] board;
    static int[][] D = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int M, N;
    final static int NOT_VISITED = -1;
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = input[0];
        N = input[1];
        board = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < M; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // Solve & Output
        System.out.println(dfs(0, 0));
    }
    private static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) return 1;
        if (dp[x][y] != NOT_VISITED) return dp[x][y];
        dp[x][y] = 0;
        for (int[] d : D) {
            final int nx = x + d[0];
            final int ny = y + d[1];
            if (isValid(nx, ny) && board[nx][ny] < board[x][y]) {
                dp[x][y] += dfs(nx, ny);
            }
        }
        return dp[x][y];
    }
    private static boolean isValid(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }
}
