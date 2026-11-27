import java.io.*;
import java.util.*;

public class Main {
    final static int MOD = 123_456_789;
    private static boolean isPrime(int num) {
        final int sqrtN = (int) Math.sqrt(num) + 1;
        for (int i = 2; i < sqrtN; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= N; ++i) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }

        int[] dp = new int[N + 1];
        dp[0] = 1;
        for (int prime : primeList) {
            for (int i = prime; i <= N; ++i) {
                dp[i] = (dp[i] + dp[i - prime]) % MOD;
            }
        }

        // Output
        System.out.println(dp[N]);
    }
}