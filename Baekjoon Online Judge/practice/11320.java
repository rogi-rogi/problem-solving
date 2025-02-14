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
            long[] info = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            final long a = info[0];
            final long b = info[1];

            // Solve
            sb.append(a / b * a / b).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}