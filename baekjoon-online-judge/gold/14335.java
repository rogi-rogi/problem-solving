import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] S = br.readLine().toCharArray();
            final int N = S.length;

            // Solve
            long[] dp = new long[N + 1];
            dp[0] = 1;
            int[] prev = new int['z' + 1];
            Arrays.fill(prev, -1);

            for (int i = 1; i <= N; ++i) {
                final int j = prev[S[i - 1]];
                dp[i] = (dp[i - 1] << 1) - (j > -1 ? dp[j - 1] : 0);
                prev[S[i - 1]] = i;
            }
            sb.append(dp[N]).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}