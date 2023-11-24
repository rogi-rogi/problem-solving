import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve
        int row = 1, col = 1;
        while (row * col < N) {
            if (row == col) ++row;
            else ++col;
        }

        // Output
        System.out.println(row + " " + col);
    }
}
