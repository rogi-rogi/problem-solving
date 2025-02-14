import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int M = Integer.parseInt(br.readLine());
        final int N = Integer.parseInt(br.readLine());

        // Solve
        int sum = 0, min = 99999;
        boolean isPrime;
        for (int num = M; num <= N; ++num) {
            if (num == 1) continue;
            isPrime = true;
            for (int i = 2; i < num; ++i) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                sum += num;
                if (min == 99999) min = num;
            }
        }

        // Output
        if (sum > 0) {
            System.out.println(sum);
            System.out.println(min);
        } else System.out.println(-1);
    }
}
