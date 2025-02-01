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
            final int a = Integer.parseInt(st.nextToken());
            final String op = st.nextToken();
            final int b = Integer.parseInt(st.nextToken());
            st.nextToken();
            final int res = Integer.parseInt(st.nextToken());

            // Solve
            sb.append(String.format("Case %d: %s\n", i, switch (op) {
                case "+" -> a + b == res ? "YES" : "NO";
                default -> a - b == res ? "YES" : "NO";
            }));
        }

        // Output
        System.out.println(sb);
    }
}
