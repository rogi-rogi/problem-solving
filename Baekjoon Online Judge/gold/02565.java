import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] dp;
    static int N;
    final static int R = 1;

    private static int LIS() {
        int max = 0;
        for (int right = 0; right < N; ++right) {
            for (int left = 0; left < right; ++left) {
                if (arr[left][R] < arr[right][R]) {
                    dp[right] = Math.max(dp[right], dp[left] + 1);
                }
            }
            max = Math.max(max, dp[right]);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        dp = new int[N];

        for (int i = 0; i < N; ++i) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // Solve
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        Arrays.fill(dp, 1);

        // Output
        System.out.println(N - LIS());
    }
}
