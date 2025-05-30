import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        boolean[] A = new boolean[N + 1];
        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N; ++i) {
            A[i + 1] = temp[i] != 0;
        }
        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int gender = Integer.parseInt(st.nextToken());
            final int num = Integer.parseInt(st.nextToken());

            // Solve
            if (gender == 1) {
                for (int i = num; i <= N; i += num) {
                    A[i] = !A[i];
                }
            } else {
                for (int i = 0; i < N; ++i) {
                    final int L = num - i, R = num + i;
                    if (L >= 1 && R <= N && A[L] == A[R]) {
                        if (L != R) {
                            A[L] = !A[L];
                        }
                        A[R] = !A[R];
                    } else {
                        break;
                    }
                }
            }
        }

        // Output
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(A[i] ? 1 : 0).append(i % 20 == 0 ? "\n" : " ");
        }
        System.out.println(sb);
    }
}