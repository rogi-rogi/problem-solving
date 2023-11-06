import java.io.*;
import java.util.*;

public class Main {
    private static int[] tree, leaf;
    
    private static void init(int node, int start, int end) {
        if (start == end) tree[node] = leaf[start];
        else {
            int mid = (start + end) >> 1;
            int child = node << 1;
            init(child, start, mid);
            init(child + 1, mid + 1, end);
            tree[node] = tree[child] + tree[child + 1];
        }
    }

    private static void update(int node, int start, int end, int idx, int diff) {
        if (idx < start || idx > end) return;
        tree[node] += diff;
        if (start != end) {
            int mid = (start + end) >> 1;
            int child = node << 1;
            update(child, start, mid, idx, diff);
            update(child + 1, mid + 1, end, idx, diff);
        }
    }

    private static int query(int target, int end) {
        int node = 1, start = 1;
        while (start < end) {
            int mid = (start + end) >> 1;
            int child = node << 1;
            if (target <= tree[child]) {
                end = mid;
                node = child;
            } else {
                start = mid + 1;
                node = child + 1;
                target -= tree[child];
            }
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // Input
        int N = Integer.parseInt(br.readLine());
        {
            leaf = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                leaf[i] = Integer.parseInt(st.nextToken());
            tree = new int[4 * N];
            init(1, 1, N);
        }
        
        // Solve
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int a = Integer.parseInt(st.nextToken());
                update(1, 1, N, i, a);
            } else {
                sb.append(query(i, N)).append('\n');
            }
        }

        // Output
        System.out.print(sb.toString());
    }
}
