import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        long[] F = new long[N + 1];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= N; ++i) {
            F[i] = F[i - 1] + F[i - 2];
        }

        // Output
        System.out.println(F[N]);
    }
}