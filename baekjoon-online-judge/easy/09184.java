import java.io.*;
import java.util.*;

public class Main {
    static int[][][] dp;
    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a > 20 || b > 20 || c > 20)
            return dp[20][20][20] = w(20, 20, 20);
        if(a < b && b < c)
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);

        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        dp = new int[51][51][51];

        // Input
        while (true) {
            st = new StringTokenizer(br.readLine());
            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());
            final int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) break;
            // Solve
            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c)));
        }

        // Output
        System.out.println(sb);
    }
}
