import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final long N = Long.parseLong(br.readLine());
        int[] dice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        if (N == 1) {
            int sum = 0;
            int max = 0;
            for (int i = 0; i < 6; ++i) {
                sum += dice[i];
                max = Math.max(max, dice[i]);
            }
            System.out.println(sum - max);
        } else {
            long single = Integer.MAX_VALUE;
            long twoSum = Integer.MAX_VALUE;
            long thrSum = Integer.MAX_VALUE;
            for (int i = 0; i < 6; ++i) {
                single = Math.min(single, dice[i]);
                for (int j = i + 1; j < 6; ++j) {
                    if (i + j == 5) continue;
                    twoSum = Math.min(twoSum, dice[i] + dice[j]);
                    for (int k = j + 1; k < 6; ++k) {
                        if (i + k == 5 || j + k == 5) continue;
                        thrSum = Math.min(thrSum, dice[i] + dice[j] + dice[k]);
                    }
                }
            }

            long res = thrSum * 4;
            res += twoSum * (8 * N - 12);
            res += single * (5 * N * N - 16 * N + 12);

            // Output
            System.out.println(res);
        }
    }
}
