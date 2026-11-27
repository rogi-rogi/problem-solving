import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        final double GOLDEN_RATIO = (1 + Math.pow(5, 0.5)) / 2;
        final double DIFF = GOLDEN_RATIO * 0.01;

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            final double A = Double.parseDouble(st.nextToken());
            final double B = Double.parseDouble(st.nextToken());

            // Solve
            sb.append(A / B >= GOLDEN_RATIO - DIFF && A / B <= GOLDEN_RATIO + DIFF ? "golden\n" : "not\n");
        }

        // Output
        System.out.println(sb);

    }
}
