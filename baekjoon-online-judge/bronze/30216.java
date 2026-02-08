import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int res = 0, cnt = 1;
        for (int i = 1; i < N; ++i) {
            if (arr[i] > arr[i - 1]) {
                ++cnt;
            } else if (arr[i] < arr[i - 1]) {
                res = Math.max(res, cnt);
                cnt = 1;
            }
        }

        // Output
        System.out.println(Math.max(res, cnt));
    }
}
