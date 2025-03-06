import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        long W = Long.parseLong(input[1]);
        int[] A = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // Solve
        long coin = 0;
        for (int i = 1; i < N; ++i) {
            if (coin == 0 && A[i] > A[i - 1]) {
                coin = W / A[i - 1];
                W %= A[i - 1];
            } else if (coin > 0 && A[i] < A[i - 1]) {
                W += coin * A[i - 1];
                coin = 0;
            }
        }

        // Output
        System.out.println(W + coin * A[N - 1]);
    }
}