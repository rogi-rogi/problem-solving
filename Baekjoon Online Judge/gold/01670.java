import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 987654321L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        int n = N / 2;
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; ++i) {
            long sum = 0;
            for (int k = 0; k <= i - 1; ++k) {
                sum = (sum + (dp[k] * dp[i - 1 - k]) % MOD) % MOD;
            }
            dp[i] = sum;
        }

        // Output
        System.out.println(dp[n] % MOD);
    }
}
