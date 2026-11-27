import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        boolean isASC = true;
        String res = "YES";
        for (int i = 1; i < N; ++i) {
            if (A[i] == A[i - 1] || !isASC && A[i] > A[i - 1]) {
                res = "NO";
                break;
            } else if (isASC && A[i] < A[i - 1]) {
                isASC = false;
            }
        }

        // Output
        System.out.println(res);
    }
}