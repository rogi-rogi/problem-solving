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
            final int S = Integer.parseInt(input[1]);
            final int E = Integer.parseInt(input[2]);

            // Solve
            int res = 0;

            if (1 < S && S < N) {
                if (Math.abs(S - E) == 1) {
                    res = 1;
                } else {
                    res = 2;
                }
            } else if (1 < E && E < N) {
                res = 1;
            }
            sb.append(res).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}