import java.io.*;
import java.util.*;

public class Main {
    static List<List<int[]>> tree;
    static int[] depth;
    static int[][] parent, minDistance, maxDistance;
    static int maxDepth;

    private static void dfs(int cur, int w, int _parent) {
        depth[cur] = depth[_parent] + 1;
        parent[cur][0] = _parent;
        minDistance[cur][0] = maxDistance[cur][0] = w;
        for (int k = 1; k <= maxDepth; ++k) {
            parent[cur][k] = parent[parent[cur][k - 1]][k - 1];
            minDistance[cur][k] = Math.min(minDistance[cur][k - 1], minDistance[parent[cur][k - 1]][k - 1]);
            maxDistance[cur][k] = Math.max(maxDistance[cur][k - 1], maxDistance[parent[cur][k - 1]][k - 1]);
        }
        for (int[] child : tree.get(cur)) {
            if (child[0] != _parent) {
                dfs(child[0], child[1], cur);
            }
        }
    }

    private static int[] LCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int[] res = {1_000_000, 0};
        for (int k = maxDepth; k >= 0; --k) {
            if (depth[parent[u][k]] >= depth[v]) {
                res[0] = Math.min(res[0], minDistance[u][k]);
                res[1] = Math.max(res[1], maxDistance[u][k]);
                u = parent[u][k];
            }
        }
        if (u == v) {
            return res;
        }
        for (int k = maxDepth; k >= 0; --k) {
            if (parent[u][k] != parent[v][k]) {
                res[0] = Math.min(res[0], minDistance[u][k]);
                res[0] = Math.min(res[0], minDistance[v][k]);
                res[1] = Math.max(res[1], maxDistance[u][k]);
                res[1] = Math.max(res[1], maxDistance[v][k]);
                u = parent[u][k];
                v = parent[v][k];
            }
        }
        res[0] = Math.min(res[0], minDistance[u][0]);
        res[0] = Math.min(res[0], minDistance[v][0]);
        res[1] = Math.max(res[1], maxDistance[u][0]);
        res[1] = Math.max(res[1], maxDistance[v][0]);
        return res;
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
        minDistance = new int[N + 1][maxDepth + 1];
        maxDistance = new int[N + 1][maxDepth + 1];
        depth = new int[N + 1];
        dfs(1, 0, 0);

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());
            // Solve
            int[] d = LCA(u, v);
            sb.append(String.format("%d %d\n", d[0], d[1]));
        }

        // Output
        System.out.println(sb);
    }
}