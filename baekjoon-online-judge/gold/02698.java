import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Solve
        int[][][] dp = new int[101][101][2];
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        for (int n = 2; n <= 100; ++n) {
            for (int k = 0; k <= 100; ++k) {
                dp[n][k][0] = dp[n - 1][k][0] + dp[n - 1][k][1];
                dp[n][k][1] = dp[n - 1][k][0];

                if (k > 0) {
                    dp[n][k][1] += dp[n - 1][k - 1][1];
                }
            }
        }

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int N = Integer.parseInt(st.nextToken());
            final int K = Integer.parseInt(st.nextToken());
            sb.append(dp[N][K][0] + dp[N][K][1]).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}