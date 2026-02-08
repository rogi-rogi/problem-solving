import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; ++i) {
            final int N = Integer.parseInt(br.readLine());
            double[] A = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            // Solve
            for (int j = 1; j < N - 1; ++j) {
                double avg = (A[j - 1] + A[j + 1]) / 2;
                if (A[j] > avg) {
                    A[j] = avg;
                }
            }
            sb.append("Case #").append(i).append(": ").append(A[N - 2]).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}
