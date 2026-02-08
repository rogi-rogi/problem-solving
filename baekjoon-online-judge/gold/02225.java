import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        // Solve
        int[][] dp = new int[N + 1][K + 1];
        final int MOD = (int) 1e9;
        for (int k = 1; k <= K; ++k) {
            dp[0][k] = 1;
        }
        for (int i = 1; i <= N; ++i) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= N; ++i) {
            for (int k = 2; k <= K; ++k) {
                dp[i][k] = (dp[i - 1][k] + dp[i][k - 1]) % MOD;
            }
        }

        // Output
        System.out.println(dp[N][K]);
    }
}