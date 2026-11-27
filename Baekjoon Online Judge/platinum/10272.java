import java.io.*;
import java.util.*;

public class Main {
    static int INF = (int)1e9;
    static double solve(int[] x, int[] y, int N) {
        double[][] dist = new double[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                double d = Math.hypot(x[i] - x[j], y[i] - y[j]);
                dist[i][j] = d;
                dist[j][i] = d;
            }
        }

        double[][] dp = new double[N][N];
        for (int i = 0; i < N; ++i) Arrays.fill(dp[i], INF);
        dp[0][1] = dist[0][1];

        for (int d = 2; d < N; ++d) {
            int prev = d - 1;
            for (int u = 0; u < prev; ++u) {
                double cur = dp[u][prev];
                if (cur == INF) continue;
                dp[u][d] = Math.min(dp[u][d], cur + dist[prev][d]);     // 아래 경로가 다음 점을 선점한 경우
                dp[prev][d] = Math.min(dp[prev][d], cur + dist[u][d]);  // 윗 경로가 다음 점을 선점한 경우
            }
        }

        int last = N - 1;
        double ans = INF;
        for (int i = 0; i < last; i++) {
            ans = Math.min(ans, dp[i][last] + dist[i][last]);
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] x = new int[N];
            int[] y = new int[N];
            for (int i = 0; i < N; ++i) {
                String[] in = br.readLine().split(" ");
                x[i] = Integer.parseInt(in[0]);
                y[i] = Integer.parseInt(in[1]);
            }
            // Solve
            sb.append(String.format("%.12f%n", solve(x, y, N)));
        }

        // Output
        System.out.print(sb);
    }
}