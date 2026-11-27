import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // Input
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; ++tc) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Solve
            Arrays.sort(input);
            String type = "scalene";
            int A = input[0];
            int B = input[1];
            int C = input[2];
            if (A + B <= C) {
                type = "invalid!";
            } else if (A == B && B == C) {
                type = "equilateral";
            } else if (A == B || B == C || C == A) {
                type = "isosceles";
            }
            sb.append(String.format("Case #%d: %s\n", tc, type));
        }

        // Output
        System.out.println(sb);
    }
}
