import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] L = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] R = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        long[] prefixSumL = new long[N];
        long[] prefixSumR = new long[N];
        for (int i = 1; i < N; ++i) {
            prefixSumL[i] = prefixSumL[i - 1] + L[i - 1];
            prefixSumR[i] = prefixSumR[i - 1] + R[i - 1];
        }

        long res = Long.MAX_VALUE, idx = -1;
        for (int i = 0; i < N; ++i) {
            final long temp = prefixSumL[i] + A[i] + (prefixSumR[N - 1] - prefixSumR[i]);
            if (temp < res) {
                res = temp;
                idx = i;
            }
        }

        // Output
        System.out.println((idx + 1) + " " + res);
    }
}