import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int L = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 2];
        A[0] = 0;
        A[N + 1] = L;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // Solve
        Arrays.sort(A);
        int left = 1, right = L - 1;
        while (left <= right) {
            final int mid = (left + right) >> 1;
            int cnt = 0;
            for (int i = 1; i < N + 2; ++i) {
                cnt += (A[i] - A[i - 1] - 1) / mid;
            }
            if (cnt > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Output
        System.out.print(left);
    }
}