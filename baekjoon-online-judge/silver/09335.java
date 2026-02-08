import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            final int N = Integer.parseInt(br.readLine());
            int[] friend = new int[N + 1];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                final int d = Integer.parseInt(st.nextToken());

                // Solve
                friend[i] = 1 << i;
                for (int j = 0; j < d; j++) {
                    friend[i] |= 1 << (Integer.parseInt(st.nextToken()) - 1);
                }
            }
            int res = N;
            for (int select = 1; select < (1 << N); ++select) {
                int cnt = 0;
                int check = 0;
                for (int i = 0; i < N; i++) {
                    if ((select & (1 << i)) != 0) {
                        check |= friend[i];
                        ++cnt;
                    }
                }

                if (check == (1 << N) - 1) {
                    res = Math.min(res, cnt);
                }
            }
            sb.append(res).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}