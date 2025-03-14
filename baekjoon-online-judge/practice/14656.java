import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] != i + 1)
                ++cnt;
        }

        // Output
        System.out.println(cnt);
    }
}