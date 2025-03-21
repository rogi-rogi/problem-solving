import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int K = Integer.parseInt(input[1]);
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int cnt = 0;
        for (int i = 0; i < N - 1; ++i) {
            if (A[i] < A[i + 1]) {
                continue;
            }
            if (A[i] < A[i + 1] + K) {
                A[i + 1] += K;
                ++cnt;
            } else {
                cnt = -1;
                break;
            }
        }

        // Output
        System.out.println(cnt);
    }
}