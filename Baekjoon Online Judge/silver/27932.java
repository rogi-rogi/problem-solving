import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int K = Integer.parseInt(in[1]);
        int[] H = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int s = 0, e = (int) 1e9;
        int result = -1;
        while (s <= e) {
            int mid = (s + e) >> 1;
            boolean[] tired = new boolean[N];
            for (int i = 0; i < N - 1; ++i) {
                if (Math.abs(H[i] - H[i + 1]) > mid) {
                    tired[i] = true;
                    tired[i + 1] = true;
                }
            }

            int cnt = 0;
            for (boolean b : tired) cnt += b ? 1 : 0;
            if (cnt <= K) {
                result = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        // Output
        System.out.println(result);
    }
}