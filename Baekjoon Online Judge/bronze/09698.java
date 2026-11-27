import java.io.*;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int T = Integer.parseInt(br.readLine());
        String[] input;
        for (int i = 1, H, M; i <= T; ++i) {
            input = br.readLine().split(" ");
            H = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);

            // Solve
            if (M < 45) {
                H = (H + 23) % 24;
            }
            sb.append(String.format("Case #%d: %d %d\n", i, H, (M + 15) % 60));
        }

        // Output
        System.out.println(sb);
    }
}
