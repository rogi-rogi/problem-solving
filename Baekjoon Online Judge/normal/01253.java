import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        long[] A = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        // Solve
        Arrays.sort(A);
        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            int left = 0, right = N - 1;
            while (left < right) {
                if (left == i) {
                    ++left;
                    continue;
                }
                if (right == i) {
                    --right;
                    continue;
                }
                long sum = A[left] + A[right];
                if (sum == A[i]) {
                    ++cnt;
                    break;
                } else if (sum < A[i]) {
                    ++left;
                } else {
                    --right;
                }
            }
        }

        // Output
        System.out.print(cnt);
    }
}