import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        long A1 = A[0];
        A[0] = 0;
        Arrays.sort(A);
        int idx = 1;
        while (idx < N) {
            if (A[idx] < A1) {
                A1 += A[idx++];
            } else {
                break;
            }
        }

        // Output
        System.out.println(idx == N ? "Yes" : "No");
    }
}