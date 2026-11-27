import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        char[] A = br.readLine().toCharArray();

        // Solve
        if (A[0] != 'B') {
            System.out.println(-1);
            return;
        }

        int[] dp = new int[N];
        final int MAX = (int) 1e10;
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (A[i] == 'B' && A[j] == 'J'
                    || A[i] == 'O' && A[j] == 'B'
                    || A[i] == 'J' && A[j] == 'O') {
                    dp[i] = (int) Math.min(dp[i], dp[j] + Math.pow(j - i, 2));
                }
            }
        }

        // Output
        System.out.println(dp[N - 1] == MAX ? -1 : dp[N - 1]);
    }
}