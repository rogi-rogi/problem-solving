import java.io.*;

public class Main {
    final static int MOD = (int) (1e4 + 7);
    static int[] dp;

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        dp = new int[N + 2];

        // Solve
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        // Output
        System.out.println(dp[N]);
    }
}
