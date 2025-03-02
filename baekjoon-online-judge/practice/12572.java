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
            int[] L = new int[N];
            int[] R = new int[N];
            for (int i = 0; i < N; ++i) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                L[i] = input[0];
                R[i] = input[1];
            }

            // Solve
            int cnt = 0;
            for (int i = 0; i < N - 1; ++i) {
                for (int j = i + 1; j < N; ++j) {
                    if ((L[i] < L[j] && R[i] > R[j]) || (L[i] > L[j] && R[i] < R[j])) {
                        ++cnt;
                    }
                }
            }
            sb.append("Case #").append(t).append(": ").append(cnt).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}
