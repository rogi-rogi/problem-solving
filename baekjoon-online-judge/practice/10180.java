import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int cnt = 0;
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                final int V = Integer.parseInt(st.nextToken());
                final double F = Double.parseDouble(st.nextToken());
                final int C = Integer.parseInt(st.nextToken());

                // Solve
                if (V * (F / C) >= D) ++cnt;
            }

            // Output
            System.out.println(cnt);
        }

    }
}
