import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // Solve
        Arrays.sort(A);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; ++i) {
            for (int j = i + 1; j < N; ++j) {
                int sum = 0;
                for (int k = 0; k < N; ++k) {
                    final int d1 = A[k] - A[i];
                    final int d2 = A[k] - A[j];
                    sum += Math.min(d1 * d1, d2 * d2);
                }
                res = Math.min(res, sum);
            }
        }

        // Output
        System.out.println(res);
    }
}