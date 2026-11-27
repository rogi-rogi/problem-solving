import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        final int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; ++i) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            final int r1 = Integer.parseInt(st.nextToken());
            final int c1 = Integer.parseInt(st.nextToken());
            final int r2 = Integer.parseInt(st.nextToken());
            final int c2 = Integer.parseInt(st.nextToken());

            // Solve
            int[][] path_list = new int[][]{
                    {r1 - 1, c1 + 2},
                    {r1 - 1, c1 - 2},
                    {r1 + 1, c1 + 2},
                    {r1 + 1, c1 - 2},
                    {r1 - 2, c1 + 1},
                    {r1 - 2, c1 - 1},
                    {r1 + 2, c1 + 1},
                    {r1 + 2, c1 - 1}
            };

            String res = "NO";
            for (int[] path : path_list) {
                if (path[0] == r2 && path[1] == c2) {
                    res = "YES";
                }
            }
            sb.append(String.format("Case %d: %s\n", i, res));
        }

        // Output
        System.out.println(sb);
    }
}
