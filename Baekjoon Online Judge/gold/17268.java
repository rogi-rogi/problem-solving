import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        final int MOD = 987_654_321;
        N /= 2;
        long[] dp = new long[N + 1];

        // Solve
        dp[0] = 1;
        for (int i = 1; i <= N; ++i) {
            dp[i] = 0;
            for (int j = 0; j < i; ++j) {
                dp[i] += ((dp[j] % MOD) * (dp[i - j - 1] % MOD)) % MOD;
            }
            dp[i] %= MOD;
        }

        // Output
        System.out.println(dp[N]);
    }
}
