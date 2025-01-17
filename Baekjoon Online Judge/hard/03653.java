import java.io.*;
import java.util.*;

public class Main {
    static int[] tree, arr;
    private static void update(int node, int start, int end, int idx, int diff) {
        if (idx < start || end < idx) return;
        tree[node] += diff;
        if (start < end) {
            final int mid = (start + end) / 2;
            update(node * 2, start, mid, idx, diff);
            update(node * 2 + 1, mid + 1, end, idx, diff);
        }
    }

    private static int query(int node, int start, int end, int i, int j) {
        if (end < i || j < start) return 0;
        if (i <= start && end <= j) return tree[node];
        final int mid = (start + end) / 2;
        return query(node * 2, start, mid, i, j) + query(node * 2 + 1, mid + 1, end, i, j);
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int N = Integer.parseInt(st.nextToken());
            final int M = Integer.parseInt(st.nextToken());
            arr = new int[N + M + 1];
            tree = new int[4 * (N + M + 1)];

            // Solve
            final int SIZE = N + M;
            for (int i = M + 1; i <= SIZE; ++i) {
                update(1, 1, SIZE, i, 1);
                arr[i - M] = i;
            }
            int idx = M + 1;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; ++i) {
                final int node = Integer.parseInt(st.nextToken());
                sb.append(query(1, 1, SIZE, 1, arr[node] - 1)).append(' ');
                update(1, 1, SIZE, arr[node], -1);
                update(1, 1, SIZE, (arr[node] = --idx), 1);
            }
            sb.append('\n');
        }

        // Output
        System.out.println(sb);
    }
}