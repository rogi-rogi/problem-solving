import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        Arrays.sort(A);
        int l = 0, r = N - 1, cnt = 0;
        while (l < r) {
            int cal = A[l] + A[r];
            if (cal == M) {
                ++l;
                --r;
                ++cnt;
            } else if (cal < M) {
                ++l;
            } else {
                --r;
            }
        }

        // Output
        System.out.println(cnt);
    }
}