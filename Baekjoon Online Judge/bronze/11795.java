import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        int A = 0, B = 0, C = 0;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            // Solve
            A += Integer.parseInt(st.nextToken());
            B += Integer.parseInt(st.nextToken());
            C += Integer.parseInt(st.nextToken());
            if (A >= 30 && B >= 30 && C >= 30) {
                final int Q = Math.min(A, Math.min(B, C));
                A -= Q;
                B -= Q;
                C -= Q;
                sb.append(Q).append('\n');
            } else {
                sb.append("NO\n");
            }
        }

        // Output
        System.out.println(sb);
    }
}
