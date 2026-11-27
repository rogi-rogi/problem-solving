import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int i = 1, N;
        // Input
        while ((N = Integer.parseInt(br.readLine())) >= 0) {
            long X = 0, Y = 0, M = 0;
            for (int j = 0; j < N; ++j) {
                st = new StringTokenizer(br.readLine());
                long x = Integer.parseInt(st.nextToken());
                long y = Integer.parseInt(st.nextToken());
                long m = Integer.parseInt(st.nextToken());

                // Solve
                X += x * m;
                Y += y * m;
                M += m;
            }
            br.readLine();
            sb.append(String.format("Case %d: %.2f %.2f\n", i, (double) X / M, (double)Y / M));
            ++i;
        }

        // Output
        System.out.println(sb);
    }
}
