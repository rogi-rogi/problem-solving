import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        while (true) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            final int N = input[0];
            final int M = input[1];
            if (N == 0 && M == 0) break;

            int[] A = new int[N];
            int[] B = new int[M];
            for (int i = 0; i < N; ++i) {
                A[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < M; ++i) {
                B[i] = Integer.parseInt(br.readLine());
            }

            // Solve
            int i = 0, j = 0, cnt = 0;
            while (i < N && j < M) {
                if (A[i] > B[j]) {
                    ++j;
                } else if (A[i] < B[j]) {
                    ++i;
                } else {
                    ++i;
                    ++j;
                    ++cnt;
                }
            }
            sb.append(cnt).append("\n");
        }

        // Output
        System.out.println(sb);
    }

}