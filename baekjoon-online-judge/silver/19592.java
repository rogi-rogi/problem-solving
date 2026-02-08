import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            final int N = Integer.parseInt(input[0]);
            final int X = Integer.parseInt(input[1]);
            final int Y = Integer.parseInt(input[2]);
            int[] V = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Solve
            double minTime = Double.MAX_VALUE;
            for (int i = 0; i < N - 1; ++i) {
                minTime = Math.min(minTime, (double) X / V[i]);
            }
            double myTime = (double) X / V[N - 1];
            if (myTime < minTime) {
                sb.append(0).append("\n");
                continue;
            }
            if (minTime <= 1.0) {
                sb.append(-1).append("\n");
                continue;
            }
            int required = (int) Math.floor(X - V[N - 1] * (minTime - 1)) + 1;

            if (required > Y) {
                sb.append(-1).append("\n");
            } else {
                sb.append(required).append("\n");
            }
        }

        // Output
        System.out.println(sb);
    }
}