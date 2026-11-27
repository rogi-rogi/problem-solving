import java.io.*;
import java.util.*;

public class Main {
    static int bestPrev(int[] prev, int j) {
        int best = prev[j];
        if (j > 0) best = Math.max(best, prev[j - 1]);
        if (j + 1 < prev.length) best = Math.max(best, prev[j + 1]);
        return best;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine().trim());
        int[] L = new int[N];
        int[] R = new int[N];
        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            L[i] = Integer.parseInt(in[0]);
            R[i] = Integer.parseInt(in[1]);
        }

        // Solve
        int minX = -N;
        int maxX = 1000 + N;
        int W = maxX - minX + 1;
        int offset = -minX;
        int[][] dp = new int[N][W];
        Arrays.fill(dp[0], 1);
        for (int x = L[0]; x <= R[0]; ++x) {
            dp[0][x + offset] = 2;
        }
        for (int i = 0; i < N - 1; ++i) {
            for (int j = 0; j < W; ++j) {
                int prevBest = bestPrev(dp[i], j);
                if (prevBest == 0) {
                    dp[i + 1][j] = 0;
                    continue;
                }
                if (L[i + 1] <= j - offset && j - offset <= R[i + 1]) {
                    dp[i + 1][j] = prevBest;
                } else {
                    dp[i + 1][j] = (prevBest == 2) ? 1 : 0;
                }
            }
        }

        // Output
        boolean result = false;
        for (int x = 0; x < W; ++x) {
            if (dp[N - 1][x] > 0) {
                result = true;
                break;
            }
        }
        System.out.println(result ? "World Champion" : "Surrender");
    }
}
