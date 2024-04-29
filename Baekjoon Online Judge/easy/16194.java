import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N + 1];

        // Solve
        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[i] == 0)
                    dp[i] = dp[i - j - 1] + P[j];
                else dp[i] = Math.min(dp[i], dp[i - j - 1] + P[j]);
            }
        }

        // Output
        System.out.println(dp[N]);
    }
}
