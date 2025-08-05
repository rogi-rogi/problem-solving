import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int C = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        // solve
        final int[][] items = new int[N + 1][2]; // (w, v)
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[100001];
        for (int i = 1; i <= N; ++i) {
            for (int w = items[i][0]; w <= 100000; ++w) {
                dp[w] = Math.max(dp[w], dp[w - items[i][0]] + items[i][1]);
            }
        }

        // output
        for (int i = 0; i <= 100000; ++i) {
            if (dp[i] >= C) {
                System.out.println(i);
                break;
            }
        }
    }
}
