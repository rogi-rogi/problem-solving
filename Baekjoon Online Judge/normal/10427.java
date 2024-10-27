import java.io.*;
import java.util.*;

public class Main {
    static long[] A;
    static long[] prefix_sum;

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        long[] input;
        while (T-- > 0) {
            input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            A = Arrays.copyOfRange(input, 1, input.length);

            // Solve
            Arrays.sort(A);
            prefix_sum = new long[A.length];
            prefix_sum[0] = A[0];
            for (int i = 1; i < A.length; ++i) {
                prefix_sum[i] = prefix_sum[i - 1] + A[i];
            }
            long res = 0;
            for (int i = 2; i <= A.length; ++i) {
                res += S(i);
            }
            sb.append(res).append('\n');
        }

        // Output
        System.out.println(sb);
    }

    private static long S(int M) {
        long ret = Long.MAX_VALUE;
        for (int i = M - 1; i < A.length; ++i) {
            ret = Math.min(ret, A[i] * M - (prefix_sum[i] - (i - M > -1 ? prefix_sum[i - M] : 0)));
        }
        return ret;
    }
}
