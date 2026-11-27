import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int[] input;
        while (true) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int M = input[0];
            double A = input[1];
            double B = input[2];
            
            // Solve
            if (M == A && A == B && B == 0) break;
            int t = (int) Math.round((M / A - M / B) * 3600);
            sb.append(String.format("%d:%02d:%02d%n", t / 3600, (t % 3600) / 60, t % 60));
        }

        // Output
        System.out.println(sb);
    }
}
