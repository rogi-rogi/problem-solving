import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[][] count = new int[N][5];
        for (int i = 0; i < N; ++i) {
            count[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // Solve
        int a = -1, b = -1;
        int max = -1;
        for (int i = 0; i < 5; ++i) {
            for (int j = i + 1; j < 5; ++j) {
                int cnt = 0;
                for (int k = 0; k < N; ++k) {
                    if (count[k][i] + count[k][j] == 2)
                        ++cnt;
                }
                if (cnt > max) {
                    a = i;
                    b = j;
                    max = cnt;
                }
            }
        }

        // Output
        sb.append(max).append("\n");
        for (int i = 0; i < 5; ++i) {
            sb.append(i == a || i == b ? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }
}