import java.io.*;
import java.util.*;

public class Main {
    static int N;

    private static int lowerBound(int[] A, int len, int target) {
        int l = 0, r = len;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (A[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private static boolean solve(
            int[] A, int[] B, int[] C,
            int x, int y, int z,
            int no, int k,
            StringBuilder sb
    ) {
        int l = 0, r = x - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;

            int rank = (mid + 1) + lowerBound(B, y, A[mid]) + lowerBound(C, z, A[mid]);
            if (rank == k) {
                sb.append(no).append(" ").append(mid + 1).append("\n");
                return true;
            }
            if (rank < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] C = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            // Solve
            String[] in = br.readLine().split(" ");
            int x = Integer.parseInt(in[0]);
            int y = Integer.parseInt(in[1]);
            int z = Integer.parseInt(in[2]);
            int k = Integer.parseInt(in[3]);

            if (solve(A, B, C, x, y, z, 1, k, sb)) continue;
            if (solve(B, A, C, y, x, z, 2, k, sb)) continue;
            solve(C, A, B, z, x, y, 3, k, sb);
        }

        // Output
        System.out.println(sb);
    }
}