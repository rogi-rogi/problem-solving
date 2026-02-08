import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        while (true) {
            st = new StringTokenizer(br.readLine());
            final int N = Integer.parseInt(st.nextToken());
            final int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            int[][] A = new int[N][2];
            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                st.nextToken();
                A[i][0] = Integer.parseInt(st.nextToken());
                A[i][1] = A[i][0] + Integer.parseInt(st.nextToken());
            }
            int[][] B = new int[M][2];
            for (int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine());
                B[i][0] = Integer.parseInt(st.nextToken());
                B[i][1] = B[i][0] + Integer.parseInt(st.nextToken());
            }

            // Solve
            for (int[] b : B) {
                int cnt = 0;
                for (int[] a : A) {
                    if (a[0] < b[1] && a[1] > b[0]) {
                        ++cnt;
                    }
                }
                sb.append(cnt).append("\n");
            }
        }

        // Output
        System.out.println(sb);
    }
}