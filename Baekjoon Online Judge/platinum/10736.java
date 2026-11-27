import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            // Solve
            if (N == 1) {
                sb.append(1).append("\n").append(1).append("\n");
                continue;
            }
            final int k = 31 - Integer.numberOfLeadingZeros(N);
            final int start = 1 << (k - 1);
            final int end = Math.min(N, start + (1 << k) - 1);

            sb.append(end - start + 1).append("\n");
            for (int x = start; x < end; ++x) {
                sb.append(x).append(" ");
            }
            sb.append(end).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}
