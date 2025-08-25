import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        List<Integer> A = new ArrayList<>();

        // Solve
        for (int i = 0; i < N; ++i) {
            final int a = Integer.parseInt(br.readLine());
            if (a < 20000 && a > 500) {
                A.add(a);
            }
        }

        long[] dp = new long[500];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int a : A) {
            int curR = a % 500;
            long realA = a - 500;

            long[] temp = dp.clone();
            for (int prevR = 0; prevR < 500; ++prevR) {
                final int nr = (prevR + curR) % 500;
                if (dp[prevR] == -1) {
                    continue;
                }
                temp[nr] = Math.max(temp[nr], dp[prevR] + realA);
            }
            dp = temp;
        }


        // Output
        if (dp[0] > 0) {
            System.out.println(dp[0]);
        } else {
            System.out.println(0);
        }
    }
}