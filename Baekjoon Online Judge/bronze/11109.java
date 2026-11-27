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
            st = new StringTokenizer(br.readLine());
            final int d = Integer.parseInt(st.nextToken());
            final int n = Integer.parseInt(st.nextToken());
            final int s = Integer.parseInt(st.nextToken());
            final int p = Integer.parseInt(st.nextToken());

            // Solve
            if (d + p * n == n * s) {
                sb.append("does not matter");
            } else if (d + p * n > n * s) {
                sb.append("do not parallelize");
            } else {
                sb.append("parallelize");
            }
            sb.append("\n");
        }

        // Output
        System.out.println(sb);
    }
}