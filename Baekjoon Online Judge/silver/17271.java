import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] in = br.readLine().split(" ");
        final int N = Integer.parseInt(in[0]);
        final int M = Integer.parseInt(in[1]);

        // Solve
        int[] dp = new int[N + 1];
        final int MOD = (int) 1e9 + 7;
        Arrays.fill(dp, 1);
        for (int i = M; i <= N; ++i) {
            dp[i] = (dp[i - 1] + dp[i - M]) % MOD;
        }

        // Output
        System.out.println(dp[N]);
    }
}