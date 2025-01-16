import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        while (N > 1) {
            if (N % 2 == 1) break;
            N >>= 1;
        }

        // Output
        System.out.println(N == 1 ? 1 : 0);
    }
}