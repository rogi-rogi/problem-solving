import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String encoded = br.readLine();

            // Solve
            final int N = (int) Math.sqrt(encoded.length());
            for (int j = N - 1; j >= 0; --j) {
                for (int i = 0; i < N; ++i) {
                    sb.append(encoded.charAt(i*N + j));
                }
            }
            sb.append("\n");
        }

        // Output
        System.out.println(sb);
    }
}
