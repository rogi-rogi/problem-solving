import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; ++tc) {
            int N = Integer.parseInt(br.readLine());
            long[] A = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            int len = N;

            // Solve
            while (len > 2) {
                int newLen = (len + 1) / 2;
                for (int i = 0; i < newLen; i++) {
                    A[i] += A[len - 1 - i];
                }
                len = newLen;
            }
            sb.append("Case #").append(tc).append(A[0] > A[1] ? ": Alice\n" : ": Bob\n");
        }

        // Output
        System.out.print(sb);
    }
}
