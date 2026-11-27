import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int min = A[0], max = A[0];
        for (int i = 1; i < N; ++i) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        // Output
        System.out.println(max - min);
    }
}