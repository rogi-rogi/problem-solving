import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr, dp;
    static int N, W;
    final static int UP = 0, DOWN = 1, FULL = 2;
    private static void solve(int start) {
        for (int i = start; i < N; ++i) {
            // 한 소대가 1x1한 칸 점령
            dp[FULL][i + 1] = 1 + Math.min(dp[UP][i], dp[DOWN][i]);

            // 한 소대가 2x1 한 칸 점령
            if (arr[UP][i] + arr[DOWN][i] <= W) {
                dp[FULL][i + 1] = Math.min(dp[FULL][i + 1], dp[FULL][i] + 1);
            }

            // 두 소대가 1x2 두 칸 점령
            if (i > 0 && arr[UP][i - 1] + arr[UP][i] <= W && arr[DOWN][i - 1] + arr[DOWN][i] <= W) {
                dp[FULL][i + 1] = Math.min(dp[FULL][i + 1], dp[FULL][i - 1] + 2);
            }

            if (i < N - 1) {
                // 한 소대가 1x1 한 칸 점령
                dp[UP][i + 1] = dp[FULL][i + 1] + 1;
                dp[DOWN][i + 1] = dp[FULL][i + 1] + 1;

                // 두 소대가 1x1, 1x2 두 칸 점령
                if (arr[UP][i] + arr[UP][i + 1] <= W) {
                    dp[UP][i + 1] = Math.min(dp[UP][i + 1], dp[DOWN][i] + 1);
                }
                if (arr[DOWN][i] + arr[DOWN][i + 1] <= W) {
                    dp[DOWN][i + 1] = Math.min(dp[DOWN][i + 1], dp[UP][i] + 1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            arr = new int[2][N];
            dp = new int[3][N + 1];
            arr[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Solve
            dp[UP][0] = 1;
            dp[DOWN][0] = 1;
            solve(0);
            int res = Math.min(N << 1, dp[FULL][N]);
            if (N > 1) {
                // 한 소대가 0, N - 1 영역 점령
                if (arr[UP][0] + arr[UP][N - 1] <= W) {
                    dp[FULL][1] = 1;
                    dp[UP][1] = 2;
                    dp[DOWN][1] = (arr[DOWN][0] + arr[DOWN][1] <= W ? 1 : 2);
                    solve(1);
                    res = Math.min(res, dp[DOWN][N - 1] + 1);
                }
                // 한 소대가 N, 2N - 1 영역 점령
                if (arr[DOWN][0] + arr[DOWN][N - 1] <= W) {
                    dp[FULL][1] = 1;
                    dp[UP][1] = (arr[UP][0] + arr[UP][1] <= W ? 1 : 2);
                    dp[DOWN][1] = 2;
                    solve(1);
                    res = Math.min(res, dp[UP][N - 1] + 1);
                }
                // 두 소대가 (0, N - 1), (N, 2N - 1) 영역 점령
                if (arr[UP][0] + arr[UP][N - 1] <= W && arr[DOWN][0] + arr[DOWN][N - 1] <= W) {
                    dp[FULL][1] = 0;
                    dp[UP][1] = dp[DOWN][1] = 1;
                    solve(1);
                    res = Math.min(res, dp[FULL][N - 1] + 2);
                }
            }
            sb.append(res).append('\n');
        }
        // Output
        System.out.println(sb);
    }
}