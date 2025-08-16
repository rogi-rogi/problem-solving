import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        long N = Long.parseLong(br.readLine());
        long start = 1, end = 2 * (long) 1e9;

        // Solve
        while (start < end) {
            final long mid = (start + end) >> 1;
            if (3 * mid * (mid - 1) + 1 >= N) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // Output
        System.out.println(end);
    }
}