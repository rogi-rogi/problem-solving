import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());

        // Solve
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            final int a = Integer.parseInt(input[0]);
            final int b = Integer.parseInt(input[1]);
            final long N = a + b;
            sb.append(N * (N - 1) * N / 2).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}