import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][N + 1];
        int[][] memo = new int[N + 1][N + 1];
        int cnt = 0;
        while (cnt < N*N) {
            String input = br.readLine();
            if (input.isEmpty()) continue;
            int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int num : nums) {
                arr[(cnt / N) + 1][(cnt % N) + 1] = num;
                ++cnt;
            }
        }

        // Solve
        int res = Integer.MIN_VALUE; // -127 * 100^2
        for (int sx = 1; sx <= N; ++sx) {
            for (int sy = 1; sy <= N; ++sy) {
                for (int[] row : memo) {
                    Arrays.fill(row, 0);
                }
                for (int i = sx; i <= N; ++i) {
                    memo[i][sy] = arr[i][sy];
                    for (int j = sy + 1; j <= N; ++j) {
                        memo[i][j] = memo[i][j - 1] + arr[i][j];
                    }
                }
                for (int i = sx; i <= N; ++i) {
                    for (int j = sy; j <= N; ++j) {
                        memo[i][j] += memo[i - 1][j];
                        if (res < memo[i][j]) res = memo[i][j];
                    }
                }
            }
        }

        // Output
        System.out.println(res);
    }
}
