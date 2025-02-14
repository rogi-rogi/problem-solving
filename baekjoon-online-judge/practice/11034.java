import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            final int A = Integer.parseInt(st.nextToken());
            final int B = Integer.parseInt(st.nextToken());
            final int C = Integer.parseInt(st.nextToken());

            // Solve
            sb.append(Math.max(B - A, C - B) - 1).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}