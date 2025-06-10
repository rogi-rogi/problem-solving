import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][];
        for (int i = 0; i < N; ++i) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // Solve
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }

        for (int gap = 1; gap < N; ++gap) {
            for (int L = 0; L < N; ++L) {
                final int R = L + gap;
                if (R >= N) {
                    break;
                }
                for (int t = L; t < R; ++t) {
                    final int matrixMul = matrix[L][0] * matrix[t][1] * matrix[R][1];
                    dp[L][R] = Math.min(dp[L][R], dp[L][t] + dp[t + 1][R] + matrixMul);
                }
            }
        }


        // Output
        System.out.print(dp[0][N - 1]);
    }
}