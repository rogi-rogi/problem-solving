import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int k = 1;
        boolean flag = true;
        for (int i = 1; i < N; ++i) {
            if (A[i] < A[i - 1]) {
                ++k;
            }
            if (k >= 2 && A[i] > A[0]) {
                flag = false;
                /*
                1 3 5 2 4 6
                5 6 1 2 3 4
                 */
            }
        }

        // Output
        System.out.println(flag ? Math.min(k, 3) : 3);
    }
}