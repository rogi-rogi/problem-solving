import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] tiles = new boolean[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            if (st.nextToken().equals("1")) {
                tiles[i + 1] = true;
            }
        }

        // Solve
        int cnt = 0;
        for (int i = 1; i <= N; ++i) {
            if (tiles[i] && !tiles[i - 1]) {
                ++cnt;
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("0")) {
                sb.append(cnt).append("\n");
            } else {
                final int idx = Integer.parseInt(st.nextToken());
                if (!tiles[idx]) {
                    tiles[idx] = true;
                    if (!tiles[idx - 1] && !tiles[idx + 1]) {
                        ++cnt;
                    } else if (tiles[idx - 1] && tiles[idx + 1]) {
                        --cnt;
                    }
                }
            }
        }

        // Output
        System.out.println(sb);
    }
}