import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine());
            int cur = 0, res = 0;
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                final int P1 = Integer.parseInt(st.nextToken());
                final int P2 = Integer.parseInt(st.nextToken());

                // Solve
                cur += (P1 - P2);
                res = Math.min(res, cur);
            }
            sb.append(Math.abs(res)).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}