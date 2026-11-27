import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int P = Integer.parseInt(br.readLine());
        double[] input;
        for (int i = 1; i <= P; ++i) {
            input = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double D = input[1];
            double A = input[2];
            double B = input[3];
            double F = input[4];
            
            // Solve
            sb.append(String.format("%d %.6f\n", i, D/(A+B)*F));
        }

        // Output
        System.out.println(sb);
    }
}
