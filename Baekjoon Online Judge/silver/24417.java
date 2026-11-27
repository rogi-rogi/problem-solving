import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = (int) (1e9 + 7);

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve
        int a = 1, b = 1;
        for (int i = 3, temp; i <= N; ++i) {
            temp = b;
            b = (a + b) % MOD;
            a = temp;
        }

        // Output
        System.out.printf("%d %d", b, N - 2);
    }
}
