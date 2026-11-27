import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int TC = Integer.parseInt(br.readLine());

        int c, v;
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            // Solve
            sb.append(String.format("You get %d piece(s) and your dad gets %d piece(s).\n", c / v, c % v));
        }

        // Output
        System.out.println(sb);
    }
}
