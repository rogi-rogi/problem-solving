import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int K = Integer.parseInt(input[1]);
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        final int HALF = N / 2;
        long cnt = 0;
        for (int i = 0; i < HALF; ++i) {
            if (A[i] != A[N - i - 1]) {
                final int diff = Math.abs(A[i] - A[N - i - 1]);
                final int Q = diff / K;
                final int R = diff % K;
                cnt += Math.min(Q + R, Q + 1 + (K - R));
            }
        }

        // Output
        System.out.println(cnt);
    }
}