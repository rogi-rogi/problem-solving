import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int M = input[0];
        final int seed = input[1];
        final int X1 = input[2];
        final int X2 = input[3];

        // Solve
        for (int a = 0; a < M; ++a) {
            for (int c = 0; c < M; ++c) {
                /*
                X1 = (a × Seed + c) % m
                X2 = (a × X1 + c) % m
                 */
                if ((a * seed + c) % M == X1 && (a * X1 + c) % M == X2) {
                    // Output
                    System.out.println(a + " " + c);
                    return;
                }
            }
        }
    }
}