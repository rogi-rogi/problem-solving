import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        int O = Integer.parseInt(br.readLine());

        --N;
        int P = O / N;
        if (O - P * N == 0) {
            // Output
            System.out.printf("%d %d", O + P - 1, O + P);
        } else {
            System.out.printf("%d %d", O + P, O + P);
        }
    }
}
