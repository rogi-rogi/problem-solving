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
            int res = 0;
            for (int i = 0; i < 9; ++i) {
                int[] score = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                // Solve
                res += score[0] - score[1];
            }
            if (res == 0) {
                sb.append("Draw\n");
            } else {
                sb.append(res > 0 ? "Yonsei" : "Korea").append("\n");
            }
        }

        // Output
        System.out.println(sb);
    }
}
