import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            double C = 0, G = 0;
            int N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                double[] input = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

                // Solve
                C += input[0];
                G += input[0] * input[1];
            }
            sb.append(String.format("%.0f %.1f\n", C, G / C));
        }

        // Output
        System.out.print(sb);
    }
}