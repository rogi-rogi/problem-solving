import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int H = input[0];
        final int M = input[1];

        // Solve
        if (M < 45) {
            H = (H + 23) % 24;
        }

        // Output
        System.out.printf("%d %d", H, (M + 15) % 60);
    }
}
