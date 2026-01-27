import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int N;
        while ((N = Integer.parseInt(br.readLine().trim())) != -1) {
            int mile = 0, prevTime = 0;

            // Solve
            while (N-- > 0) {
                String[] in = br.readLine().split(" ");
                int s = Integer.parseInt(in[0]);
                int t = Integer.parseInt(in[1]);
                mile += s * (t - prevTime);
                prevTime = t;
            }
            sb.append(mile).append(" miles\n");
        }

        // Output
        System.out.print(sb);
    }
}
