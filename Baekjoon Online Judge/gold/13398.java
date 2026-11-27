import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int[][] dp = new int[N][2];
        final int SEL = 1, UN_SEL = 0;
        dp[0][UN_SEL] = dp[0][SEL] = arr[0];

        int res = arr[0];
        for (int i = 1; i < N; ++i) {
            dp[i][UN_SEL] = arr[i] + Math.max(dp[i - 1][UN_SEL], 0);
            dp[i][SEL] = Math.max(dp[i - 1][UN_SEL], dp[i - 1][SEL] + arr[i]);
            res = Math.max(res, Math.max(dp[i][UN_SEL], dp[i][SEL]));
        }

        // Output
        System.out.println(res);
    }
}
