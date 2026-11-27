import java.io.*;
import java.util.*;

public class Main {
    public static void   main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        final int K = Integer.parseInt(br.readLine());
        for (int i = 1; i <= K; ++i) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            final int W = Integer.parseInt(st.nextToken());
            final int E = Integer.parseInt(st.nextToken());

            int res = 0;
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                final int a = Integer.parseInt(st.nextToken());
                final int b = Integer.parseInt(st.nextToken());
                final int c = Integer.parseInt(st.nextToken());
                final int d = Integer.parseInt(st.nextToken());

                // Solve
                res += Math.max(a * W + c * E, b * W + d * E);
            }
            sb.append(String.format("Data Set %d:\n%d\n\n", i, res));
        }

        // Output
        System.out.println(sb);
    }
}