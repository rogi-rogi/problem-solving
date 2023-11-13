import java.io.*;
import java.util.*;

public class Main {
    private static long[] tree, leaf;

    private static void init(int node, int start, int end) {
        if (start == end) tree[node] = leaf[start];
        else {
            int mid = (start + end) >> 1;
            int child = node << 1;
            init(child, start, mid);
            init(child + 1, mid + 1, end);

            // query
            tree[node] = tree[child] + tree[child + 1];
        }
    }

    private static  void update(int node, int start, int end, int idx, int val) {
        if (end < idx || idx < start) return;
        if (start == end) {
            tree[node] = leaf[idx] = val;
            return;
        }
        int mid = (start + end) >> 1;
        int child = node << 1;
        update(child, start, mid, idx, val);
        update(child + 1, mid + 1, end, idx, val);

        // query
        tree[node] = tree[child] + tree[child + 1];
    }

    private static long query(int node, int start, int end, int i, int j) {
        if (end < i || j < start) return 0;
        if (i <= start && end <= j) return tree[node];

        int mid = (start + end) >> 1;
        int child = node << 1;

        long lSum = query(child, start, mid, i, j);
        long rSum = query(child + 1, mid + 1, end, i, j);
        return lSum + rSum;
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // Input
        int N = Integer.parseInt(br.readLine());
        {
            leaf = new long[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; ++i)
                leaf[i] = Long.parseLong(st.nextToken());
            tree = new long[4 * N];
            init(1, 1, N);
        }

        // Solve
        int queryCnt = Integer.parseInt(br.readLine());
        while (queryCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int val = Integer.parseInt(st.nextToken());
                update(1, 1, N, i, val);
            } else {
                int j = Integer.parseInt(st.nextToken());
                sb.append(query(1, 1, N, i, j)).append('\n');
            }
        }

        // Output
        System.out.print(sb.toString());
    }
}
