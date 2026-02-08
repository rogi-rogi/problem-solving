import java.io.*;
import java.util.*;

public class Main {
    public static void   main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        while (true) {
            int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (num[0] + num[1] + num[2] + num[3] == 0) break;

            // Solve
            int cnt = num[0];
            for (int i = 1; i < 4; ++i) {
                cnt = (int) Math.pow(cnt, num[i]);
            }
            sb.append(cnt).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}