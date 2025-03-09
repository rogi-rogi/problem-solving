import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            A[i] = Integer.parseInt(br.readLine().split(" ")[2]);
        }

        // Solve
        int[] dp = new int[N + 1];
        dp[1] = A[1];
        for (int i = 2; i <= N; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i]);
        }

        // Output
        System.out.println(dp[N]);
    }
}