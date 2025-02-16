import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int P = Integer.parseInt(br.readLine());
        for (int i = 1; i <= P; ++i) {
            final int N = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()[1];

            // Solve
            sb.append(String.format("%d %d %d %d\n", i, (N*(N+1)/2), N * N, N * (N + 1)));
        }

        // Output
        System.out.println(sb);
    }
}