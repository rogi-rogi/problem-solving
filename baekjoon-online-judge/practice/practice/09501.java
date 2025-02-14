import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        int[] input;
        while (T-- > 0) {
            input = inputArray(br);
            int N = input[0];
            final int D = input[1];
            int cnt = 0;
            while (N-- > 0) {
                input = inputArray(br);
                final int V = input[0];
                final int F = input[1];
                final double C = input[2];

                // Solve
                if (V * (F/C) >= D) ++cnt;
            }
            sb.append(cnt).append('\n');
        }

        // Output
        System.out.println(sb);
    }

    private static int[] inputArray(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
