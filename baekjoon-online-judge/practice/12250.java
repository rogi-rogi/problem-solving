import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; ++i) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Solve
            int cnt = 0;
            for (int a = 0; a < arr[0]; ++a) {
                for (int b = 0; b < arr[1]; ++b) {
                    if ((a & b) < arr[2])
                        ++cnt;

                }
            }
            sb.append("Case #").append(i).append(": ").append(cnt).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}
