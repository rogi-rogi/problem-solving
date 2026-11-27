import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[N];
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // Solve
        Arrays.sort(A, Comparator.reverseOrder());
        long sum = 0;
        for (int i = 0; i < N; ++i) {
            if (A[i] - i < 0) {
                break;
            } else {
                sum += A[i] - i;
            }
        }

        // Output
        System.out.println(sum);
    }
}