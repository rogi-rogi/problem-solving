import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        st = new StringTokenizer(br.readLine());
        final int H = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int S = Integer.parseInt(st.nextToken());
        int time = 3600 * H + 60 * M + S;
        final int DAY = 86400;
        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Solve
            if (input[0] == 3) {
                sb.append(String.format("%d %d %d\n", time / 3600, (time / 60) % 60, time % 60));
            } else if (input[0] == 1) {
                time = (time + input[1]) % DAY;
            } else if (input[0] == 2) {
                time = (time - input[1]) % DAY;
                while (time < 0) {
                    time += DAY;
                }
            }
        }

        // Output
        System.out.println(sb);
    }
}