import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        String[] info = br.readLine().split(" ");
        final int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int[] prefix_sum = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            prefix_sum[i + 1] = arr[i] + prefix_sum[i];
        }

        int i, j;
        while (M-- > 0) {
            info = br.readLine().split(" ");
            i = Integer.parseInt(info[0]);
            j = Integer.parseInt(info[1]);
            sb.append(prefix_sum[j] - prefix_sum[i - 1]).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}
