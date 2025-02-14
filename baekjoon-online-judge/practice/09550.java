import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            final int K = Integer.parseInt(br.readLine().split(" ")[1]);

            // Solve
            int res = 0;
            for (int candy : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
                res += candy / K;
            }
            sb.append(res).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}
