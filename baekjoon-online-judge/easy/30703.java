import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] C = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        for (int i = 0; i < N; ++i) {
            B[i] = Math.abs(B[i] - A[i]);
        }

        int res = 0, q = (B[0] / C[0]) % 2;
        for (int i = 0; i < N; ++i) {
            final int cnt = B[i] / C[i];
            if (B[i] % C[i] != 0 || cnt % 2 != q) {
                res = -1;
                break;
            }
            res = Math.max(res, cnt);
        }

        // Output
        System.out.println(res);
    }
}