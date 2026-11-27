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
            br.readLine();

            // Solve
            final int sum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
            if (sum > 0) {
                sb.append("Right\n");
            } else if (sum < 0) {
                sb.append("Left\n");
            } else {
                sb.append("Equilibrium\n");
            }
        }

        // Output
        System.out.println(sb);
    }
}