import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        final int MOD = (int) (1e9 + 7);
        long[] prefixSum = new long[N];
        prefixSum[0] = A[0];
        for (int i = 1; i < N; ++i) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        long res = 0;
        for (int i = 0; i < N; ++i) {
            res = (res + A[i] * (prefixSum[N - 1] - prefixSum[i]) % MOD) % MOD;
        }

        // Output
        System.out.println(res);
    }
}