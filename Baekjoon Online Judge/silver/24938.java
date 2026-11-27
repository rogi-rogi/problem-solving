import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        long[] A = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        // Solve
        final long sum = Arrays.stream(A).sum();
        final int need = (int) (sum / N);
        long result = 0;
        for (int i = 0; i < N - 1; ++i) {
            final long diff = A[i] - need;
            result += Math.abs(diff);
            A[i + 1] += diff;
        }

        // Output
        System.out.println(result);
    }
}