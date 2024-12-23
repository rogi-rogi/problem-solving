import java.io.*;

public class Main {
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final long MOD = (long)1e9 + 3;

        // Input
        final int N = Integer.parseInt(br.readLine());
        final int K = Integer.parseInt(br.readLine());
        dp = new long[N + 1][N + 1];

        // Solve
        for (int i = 1; i <= N; ++i) {
            dp[i][1] = i;
        }
        for (int n = 4; n <= N; ++n) {
            final int half = n >> 1;
            for (int k = 2; k <= half; ++k) {
                dp[n][k] = (dp[n - 1][k] + dp[n - 2][k - 1]) % MOD;
            }
        }

        // Output
        System.out.println(dp[N][K]);
    }
}
