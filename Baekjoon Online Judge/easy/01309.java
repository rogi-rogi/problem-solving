import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        final int MOD = 9901;

        // Solve
        int[] dp = new int[(int) 1e5 + 1];

        /*
        x(i), y(i) = z(i)

        x(i + 1) = x(i) + 2y(i)
        y(i + 1) = x(i) + y(i)

        x(i + 1) = y(i + 1) + y(i)
        x(i) = y(i) + y(i - 1)

        y(i + 1) = 2y(i) + y(i - 1)
        dp[i] = 2dp[i - 1] + dp[i - 2]
        */
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i <= N; ++i) {
            dp[i] = (2*dp[i-1] + dp[i-2]) % MOD;
        }

        // Output
        System.out.println(dp[N]);
    }
}
