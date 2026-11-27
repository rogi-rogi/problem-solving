import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] input;
        while (true) {
            // Input
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            final int a = input[0], b = input[1];
            if (a == 0 && b == 0) break;
            // Solve
            sb.append(String.format("%d %d / %d\n", a / b, a % b, b));
        }
        // Output
        System.out.println(sb);
    }
}