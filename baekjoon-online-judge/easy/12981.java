import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        Arrays.sort(A);
        int cnt = A[0];
        A[1] -= cnt;
        A[2] -= cnt;
        cnt += A[1] / 3;
        cnt += A[2] / 3;
        cnt += A[1] % 3 != 0 ? 1 : 0;
        cnt += A[2] % 3 != 0 ? 1 : 0;
        if (A[1] % 3 == 1 && A[2] % 3 == 1) {
            --cnt;
        }

        // Output
        System.out.println(cnt);
    }
}