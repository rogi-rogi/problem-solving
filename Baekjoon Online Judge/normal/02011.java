import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 1000000;

        // Input
        char[] N = br.readLine().toCharArray();

        // Solve
        if (N[0] == '0') {
            System.out.println(0);
            return;
        }
        int[] dp = new int[N.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N.length; ++i) {
            {
                if (N[i - 1] != '0'){
                    dp[i] = dp[i - 1];
                }
                final int num = (N[i - 2] - '0') * 10 + (N[i - 1] - '0');
                if (10 <= num && num <= 26) {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                }
            }
        }

        // Output
        System.out.println(dp[N.length]);
    }
}
