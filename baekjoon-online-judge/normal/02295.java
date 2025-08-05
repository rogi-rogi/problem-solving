import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // Solve
        final int two_sum_size = (N * (N + 1)) >> 1;
        int[] sum_xy = new int[two_sum_size];

        for (int x = 0, idx = 0; x < N; ++x) {
            for (int y = x; y < N; ++y) {
                sum_xy[idx++] = arr[x] + arr[y];
            }
        }
        Arrays.sort(arr);
        Arrays.sort(sum_xy);

        for (int k = N - 1; k >= 0; --k) {
            for (int z = k - 1; z >= 0; --z) {
                if (Arrays.binarySearch(sum_xy, arr[k] - arr[z]) > -1) {

                    // Output
                    System.out.println(arr[k]);
                    return;
                }
            }
        }
    }
}
