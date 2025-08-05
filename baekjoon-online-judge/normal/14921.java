import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        Arrays.sort(A);
        int left = 0, right = N - 1;
        int min = Integer.MAX_VALUE, B = 0;
        while (left < right) {
            int sumAB = A[left] + A[right];
            if (Math.abs(sumAB) < min) {
                min = Math.abs(sumAB);
                B = sumAB;
            }
            if (sumAB > 0) {
                --right;
            } else {
                ++left;
            }
        }

        // Output
        System.out.print(B);
    }
}