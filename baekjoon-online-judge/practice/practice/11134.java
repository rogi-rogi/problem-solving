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
            final int N = Integer.parseInt(st.nextToken());
            final int C = Integer.parseInt(st.nextToken());

            // Solve
            sb.append(N / C + (N % C == 0 ? 0 : 1)).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}