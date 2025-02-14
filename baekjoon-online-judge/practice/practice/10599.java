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
            int a = input[0];
            int b = input[1];
            int c = input[2];
            int d = input[3];

            // Solve
            if (a == 0 && b == 0 && c == 0 && d == 0) break;
            sb.append(String.format("%d %d \n", c - b, d - a));
        }

        // Output
        System.out.println(sb);
    }
}
