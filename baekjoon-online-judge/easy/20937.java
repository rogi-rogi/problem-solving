import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        br.readLine();
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        Arrays.sort(A);
        int prev = A[A.length - 1];
        int res = 1;
        int cnt = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] == prev) {
                ++cnt;
                res = Math.max(res, cnt);
            } else {
                prev = A[i];
                cnt = 1;
            }
        }

        // Output
        System.out.println(res);
    }
}