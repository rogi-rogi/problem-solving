import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        while (true) {
            String[] input = br.readLine().split(" ");
            final int N = Integer.parseInt(input[0]);
            final int M = Integer.parseInt(input[1]);
            final int K = Integer.parseInt(input[2]);

            if (N == 0 && M == 0 && K == 0)
                break;

            // Solve & Output
            System.out.println(N / 2 + N % 2 <= K ? "-1" : Math.max(N / 2 + 1 - M, 0));
        }
    }
}
