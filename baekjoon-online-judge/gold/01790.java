import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long K = Integer.parseInt(input[1]);

        // Solve
        long gap = 9;
        int digit = 1;
        for (; gap * digit < K; ++digit, gap *= 10) {
            K -= gap * digit;
        }
        --K;
        long num = (long)Math.pow(10, digit -1) + (K / digit);

        // Output
        if (num > N) System.out.println(-1);
        else System.out.println(String.valueOf(num).charAt((int)K % digit));
    }
}
