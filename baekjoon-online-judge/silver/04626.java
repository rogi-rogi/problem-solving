import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Solve
            int N = in[0];
            final int D = in[1];
            final int B = in[2];
            final int E = in[3];

            sb.append("Problem set ").append(t).append(": ")
                    .append(N).append(" / ").append(D)
                    .append(", base 7 digits ")
                    .append(B).append(" through ").append(E).append(": ");

            N %= D;
            for (int i = 0; i < B; ++i) {
                N = (N * 7) % D;
            }
            for (int i = B; i <= E; ++i) {
                N *= 7;
                sb.append(N / D);
                N %= D;
            }
            sb.append("\n");
        }

        // Output
        System.out.print(sb);
    }
}