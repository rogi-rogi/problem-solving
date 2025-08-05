import java.io.*;
import java.util.*;

public class Main {
    static List<List<int[]>> tree;
    static int[] depth;
    static long[] distance;
    static int[][] parent;
    static int maxDepth;

    private static void dfs(int cur, int w, int _parent) {
        depth[cur] = depth[_parent] + 1;
        parent[cur][0] = _parent;
        distance[cur] = distance[_parent] + w;
        for (int k = 1; k <= maxDepth; ++k) {
            parent[cur][k] = parent[parent[cur][k - 1]][k - 1];
        }
        for (int[] child : tree.get(cur)) {
            if (child[0] != _parent) {
                dfs(child[0], child[1], cur);
            }
        }
    }

    private static int LCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int diff = depth[u] - depth[v];
        for (int k = 0; diff > 0; ++k, diff >>= 1) {
            if ((diff & 1) == 1) u = parent[u][k];
        }
        if (u == v) {
            return u;
        }
        for (int k = maxDepth; k >= 0; --k) {
            if (parent[u][k] != parent[v][k]) {
                u = parent[u][k];
                v = parent[v][k];
            }
        }
        return parent[u][0];
    }

    private static  int getKNode(int u, int v, int k) {
        int lca = LCA(u, v);
        int leftMidDepth = depth[u] - depth[lca] + 1;
        int rightDepth = depth[v] - depth[lca];
        if (k <= leftMidDepth) {
            int diff = k - 1;
            for (int j = 0; diff > 0; ++j, diff >>= 1) {
                if ((diff & 1) == 1) u = parent[u][j];
            }
            return u;
        } else {
            int diff = rightDepth - (k - leftMidDepth);
            for (int j = 0; diff > 0; ++j, diff >>= 1) {
                if ((diff & 1) == 1) v = parent[v][j];
            }
            return v;
        }
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= N; ++i) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());
            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());
            final int w = Integer.parseInt(st.nextToken());
            tree.get(u).add(new int[]{v, w});
            tree.get(v).add(new int[]{u, w});
        }

        maxDepth = (int) Math.ceil(Math.log(N) / Math.log(2));
        parent = new int[N + 1][maxDepth + 1];
        depth = new int[N + 1];
        distance = new long[N + 1];
        dfs(1, 0, 0);

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int query = Integer.parseInt(st.nextToken());
            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());
            // Solve
            if (query == 1) {
                sb.append(distance[u] + distance[v] - 2 * distance[LCA(u, v)]).append('\n');
            } else {
                sb.append(getKNode(u, v, Integer.parseInt(st.nextToken()))).append('\n');
            }
        }

        // Output
        System.out.println(sb);
    }
}