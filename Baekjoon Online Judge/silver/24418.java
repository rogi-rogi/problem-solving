import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve & Output
        System.out.printf("%d %d", matrix_path_rec(N, N), N * N);
    }
    private static int matrix_path_rec(int i, int j) {
        if (i == 0 || j == 0) {
            return 1;
        } else {
            return matrix_path_rec(i - 1, j) + matrix_path_rec(i, j - 1);
        }
    }
}
