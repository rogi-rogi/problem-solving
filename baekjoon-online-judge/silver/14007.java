import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int cnt = N;
        for (int i = 0; i < N; ++i) {
            long prevDiff = 0;
            for (int j = i + 1; j < N; ++j) {
                long diff = A[j] - A[j - 1];
                if (diff == 0 || prevDiff != 0 && diff * prevDiff > 0) {
                    break;
                }
                ++cnt;
                prevDiff = diff;
            }
        }

        // Output
        System.out.println(cnt);
    }
}