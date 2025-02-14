import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            String[] input = br.readLine().split(" ");
            final int A = Integer.parseInt(input[0]);
            final int B = Integer.parseInt(input[1]);
            
            // Solve
            int cnt = 0;
            for (int i = (int)Math.cbrt(A); i <= (int)Math.cbrt(B); ++i) {
                if (A <= i * i * i && i * i * i <= B) {
                    ++cnt;
                }
            }
            sb.append(String.format("Case #%d: %d\n", t, cnt));
        }

        // Output
        System.out.println(sb);
    }
}
