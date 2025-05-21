import java.io.*;
import java.util.*;

public class Main {
    private static void solve(long[][] dp, int si, int sj, int N, int M) {
        dp[1][0] = 1;
        for (int i = si; i <= N; ++i) {
            for (int j = sj; j <= M; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        // Solve
        long[][] dp = new long[N + 1][M + 1];
        if (K == 0) {
            solve(dp, 1, 1, N, M);
        } else {
            final int midRow = (K - 1) / M + 1;
            final int midCol = (K - 1) % M + 1;
            solve(dp, 1, 1, midRow, midCol);
            solve(dp, midRow, midCol, N, M);
        }

        // Output
        System.out.println(dp[N][M]);
    }
}