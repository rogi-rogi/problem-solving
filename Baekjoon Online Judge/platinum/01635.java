import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        while (M-- > 0) {
            int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Solve
            final int sum = Arrays.stream(A).sum();
            if (sum == 0) {
                sb.append("1 ".repeat(Math.max(0, N - 1)));
                sb.append("1\n");
                continue;
            }

            int prefix = 0, point = -1;
            for (int i = 0; i < N; ++i) {
                prefix += A[i];
                if (prefix * 2 == sum) {
                    point = i;
                    break;
                }
            }
            sb.append("1 ".repeat(point + 1));
            sb.append("-1 ".repeat(Math.max(0, N - (point + 1))));
            sb.append("\n");
        }

        // Output
        System.out.println(sb);
    }
}
