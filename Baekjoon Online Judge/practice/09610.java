import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        int x, y;
        String[] input;
        int[] P = new int[5];
        while (N-- > 0) {
            input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);

            // Solve
            if (x == 0 || y == 0) {
                ++P[4];
            } else if (x > 0) {
                if (y > 0) ++P[0];
                else ++P[3];
            } else {
                if (y > 0) ++P[1];
                else ++P[2];
            }
        }

        // Output
        System.out.printf("Q1: %d\nQ2: %d\nQ3: %d\nQ4: %d\nAXIS: %d\n%n", P[0], P[1], P[2], P[3], P[4]);
    }
}
