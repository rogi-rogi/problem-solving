import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int score = Integer.parseInt(st.nextToken());
        final int P = Integer.parseInt(st.nextToken());
        int[] A;

        // Solve
        int idx = 0, rank = 1;
        if (N != 0) {
            A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < N; i++) {
                if (A[i] > score) {
                    ++rank;
                } else if (A[i] < score) {
                    break;
                }
                ++idx;
            }
            if (idx == P) {
                rank = -1;
            }
        }

        // Output
        System.out.println(rank);
    }
}