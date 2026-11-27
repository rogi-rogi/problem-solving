import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int M = Integer.parseInt(input[0]);
        final int N = Integer.parseInt(input[1]);
        int[] L = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        Arrays.sort(L);
        int res = 0;
        int left = 1;
        int right = L[N - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < N; ++i) {
                cnt += L[i] / mid;
            }
            if (cnt >= M) {
                if (res < mid) res = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }

        // Output
        System.out.println(res);
    }
}
