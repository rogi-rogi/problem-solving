import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve
        final int MOD = (int) 1e9;
        int[][] dp = new int[N + 1][11];
        for (int j = 1; j <= 9; ++j) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= N; ++i) {
            for (int j = 0; j <= 9; ++j) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1];
                } else if (j == 9) {
                    dp[i][9] = dp[i - 1][8];
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }
        long sum = 0;
        for (int num : dp[N]) {
            sum = (sum + num) % MOD;
        }

        // Output
        System.out.println(sum);
    }
}