import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int N = Integer.parseInt(st.nextToken());
            long[] A = new long[N];

            long candidate  = -1, virtualCnt = 0;
            for (int i = 0; i < N; ++i) {
                // Solve
                A[i] = Long.parseLong(st.nextToken());

                if (virtualCnt == 0) {
                    candidate  = A[i];
                    virtualCnt = 1;
                } else if (A[i] == candidate) {
                    ++virtualCnt;
                } else {
                    --virtualCnt;
                }
            }

            long actualCnt = 0;
            for (long a : A) {
                if (a == candidate) ++actualCnt;
            }
            sb.append(actualCnt > N / 2 ? candidate : "SYJKGW").append("\n");
        }

        // Output
        System.out.println(sb);
    }
}