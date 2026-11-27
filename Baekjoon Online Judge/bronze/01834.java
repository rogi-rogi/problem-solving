import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve
        long res = 0;
        for (long i = 1; i < N; ++i) {
            res += N * i + i;
        }

        // Output
        System.out.println(res);
    }
}