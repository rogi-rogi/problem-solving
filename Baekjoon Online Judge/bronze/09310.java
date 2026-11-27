import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // Input
        int N;
        int[] input;
        int a, b, c;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            a = input[0];
            b = input[1];
            c = input[2];

            // Solve
            if (b - a == c - b) {
                sb.append((N*(2*a + (N-1)*(b-a))) / 2);
            } else if (b / a == c / b) {
                sb.append(a * (int)(Math.pow((int)(b / a), N) - 1) / (b / a - 1));
            }
            sb.append('\n');
        }

        // Output
        System.out.println(sb);
    }
}
