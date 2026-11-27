import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve
        int res = ((N % 4 == 0 && N % 100 != 0) || N % 400 == 0) ? 30 : 29;

        // Output
        System.out.println(res);
    }
}