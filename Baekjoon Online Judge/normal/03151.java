import java.io.*;
import java.util.*;

public class Main {
    static int[] A;

    private static int lowerBound(int c, long target) {
        int left = c, right = A.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int upperBound(int c, long target) {
        int left = c, right = A.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (A[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        Arrays.sort(A);
        long cnt = 0;
        for (int a = 0; a < N - 2; ++a) {
            for (int b = a + 1; b < N; ++b) {
                long sumAB = A[a] + A[b];
                cnt += upperBound(b + 1, -sumAB) - lowerBound(b + 1, -sumAB);
            }
        }

        // Output
        System.out.print(cnt);
    }
}