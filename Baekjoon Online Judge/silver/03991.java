import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        st = new StringTokenizer(br.readLine());
        final int h = Integer.parseInt(st.nextToken());
        final int w = Integer.parseInt(st.nextToken());
        final int c = Integer.parseInt(st.nextToken());
        int[] color = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] A = new int[h][w];

        // Solve
        int idx = 0;
        for (int j = 0; j < w; ++j) {
            for (int i = h - 1; i >= 0; --i) {
                while (color[idx] <= 0) {
                    ++idx;
                }
                A[i][j] = idx + 1;
                --color[idx];
            }
        }

        // Output
        for (int i = 0; i < h; ++i) {
            for (int col : A[i]) {
                sb.append(col);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}