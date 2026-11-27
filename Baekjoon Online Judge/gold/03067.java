import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            br.readLine();
            int[] coins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int M = Integer.parseInt(br.readLine());

            // Solve
            int[] dp = new int[M + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int m = coin; m <= M; ++m) {
                    dp[m] += dp[m - coin];
                }
            }
            sb.append(dp[M]).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}