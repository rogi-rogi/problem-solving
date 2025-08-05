import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, dp;
  
    private static void LIS() {
        for (int right = 0; right < arr.length; ++right)
            for (int left = 0; left < right; ++left)
                if (arr[left] < arr[right] && dp[left] == dp[right])
                    dp[right] = dp[left] + 1;
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[N];

        // Solve
        Arrays.fill(dp, 1);
        LIS();

        // Output
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
