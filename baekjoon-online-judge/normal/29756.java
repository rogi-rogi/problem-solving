import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int K = Integer.parseInt(input[1]);
        int[] S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] H = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int[][] dp = new int[N + 1][101];
        for (int i = 1; i <= N; ++i) {
            final int need = H[i - 1];
            final int score = S[i - 1];
            for (int h = 0; h <= 100; ++h) {
                int nextH = Math.min(100, h + K);
                dp[i][h] = dp[i - 1][nextH];
                if (nextH - need >= 0) {
                    dp[i][h] = Math.max(dp[i][h], dp[i - 1][nextH - need] + score);
                }
            }
        }

        // Output
        System.out.println(dp[N][100]);
    }
}