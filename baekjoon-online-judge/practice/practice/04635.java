import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input & Solve
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;
            int mile = 0, prevTime = 0;
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                mile += s * (t - prevTime);
                prevTime = t;
            }
            sb.append(mile).append(" miles\n");
        }

        // Output
        System.out.print(sb);
    }
}
