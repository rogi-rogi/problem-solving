import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int M = Integer.parseInt(br.readLine());

        // Solve
        Arrays.sort(arr);
        int start = 1, end = arr[N - 1];
        int res = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            for (int i = 0; i < N; ++i) sum += Math.min(mid, arr[i]);
            if (sum <= M) {
                start = mid + 1;
                res = mid;
            } else {
                end = mid - 1;
            }
        }

        // Output
        System.out.println(res);
    }
}
