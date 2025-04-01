import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            final int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            while (M-- > 0) {
                br.readLine();
            }

            // Solve
            sb.append(N - 1).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}