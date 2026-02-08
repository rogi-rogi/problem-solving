import java.io.*;
import java.util.*;

public class Main {
    final static int MAX = 10_001;
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int N = input[0];
        final int K = input[1];
        int[] coins = new int[N];
        for (int i = 0; i < N; ++i) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // Solve
        int[] dp = new int[K + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= K; ++i) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // Output
        System.out.println(dp[K] == MAX ? -1 : dp[K]);
    }
}
