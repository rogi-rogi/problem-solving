import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int K = Integer.parseInt(br.readLine());

        // Solve
        int N = 1;
        int cnt = 0;
        while (N < K) {
            N <<= 1;
        }
        final int size = N;
        while (K > 0) {
            if (K >= N) {
                K -= N;
            } else {
                N >>= 1;
                ++cnt;
            }
        }

        // Output
        System.out.print(size + " " + cnt);
    }
}