import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int L = Integer.parseInt(input[1]);
        final int W = Integer.parseInt(input[2]);
        final int H = Integer.parseInt(input[3]);

        // Solve
        double start = 0, end = Math.max(L, Math.max(W, H));
        double mid;
        for (int i = 0; i < 10000; i++) {
            mid = (start + end) / 2;
            long count = (long)(L / mid) * (long)(W / mid) * (long)(H / mid);
            if (count >= N) {
                start = mid;
            } else {
                end = mid;
            }
        }

        // Output
        System.out.printf("%.10f\n", end);
    }
}