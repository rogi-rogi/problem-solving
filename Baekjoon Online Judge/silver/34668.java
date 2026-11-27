import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            int M = Integer.parseInt(br.readLine());

            // Solve
            int Q = M / 50;
            int hour = 6 + (Q / 5);
            int min = 12 * (Q % 5) + 6;
            sb.append(String.format("%02d", hour)).append(":")
                    .append(String.format("%02d", min)).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}