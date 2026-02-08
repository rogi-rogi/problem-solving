import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            final int N = Integer.parseInt(br.readLine());
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Solve
            if (N == 1) {
                sb.append(String.format("Case #%d: 0\n", t));
            } else {
                final int A1 = input[0];
                final int B1 = input[1];
                input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                final int A2 = input[0];
                final int B2 = input[1];
                final int res = (A1 < A2 && B1 > B2 ? 1:0) + (A1 > A2 && B1 < B2 ? 1:0);
                sb.append(String.format("Case #%d: %d\n", t, res));
            }
        }

        // Output
        System.out.println(sb);
    }
}
