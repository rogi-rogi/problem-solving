import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            final int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            int max = -1, idx = -1, sum = 0;
            for (int i = 0; i < N; ++i) {
                A[i] = Integer.parseInt(br.readLine());
                sum += A[i];
                // Solve
                if (A[i] > max) {
                    max = A[i];
                    idx = i;
                }
            }

            int maxCnt = 0;
            for (int a : A) {
                if (a == max) {
                    ++maxCnt;
                }
            }
            if (maxCnt == 1) {
                sb.append(max > sum >> 1 ? "majority winner " : "minority winner ").append(idx + 1).append("\n");
            } else {
                sb.append("no winner\n");
            }
        }
        // Output
        System.out.println(sb);
    }
}