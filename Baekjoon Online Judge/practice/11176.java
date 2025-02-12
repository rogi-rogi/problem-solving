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
            final int E = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int cnt = 0;
            while (N-- > 0) {

                // Solve
                if (Integer.parseInt(br.readLine()) > E) {
                    ++cnt;
                }
            }
            sb.append(cnt).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}