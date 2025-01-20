import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> tree;
    static int[] depth;
    static int[][] parent;
    static int maxDepth;

    private static void dfs(int node, int parentNode) {
        depth[node] = depth[parentNode] + 1;
        parent[node][0] = parentNode;
        for (int i = 1; i <= maxDepth; ++i) {
            parent[node][i] = parent[parent[node][i - 1]][i - 1];
        }
        for (int child : tree.get(node)) {
            if (child != parentNode) {
                dfs(child, node);
            }
        }
    }

    private static int LCA(int u, int v) {
        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        for (int i = maxDepth; i >= 0; --i) {
            if (depth[parent[v][i]] >= depth[u]) {
                v = parent[v][i];
            }
        }
        if (u == v) return u;

        int res = u;
        for (int i = maxDepth; i >= 0; --i) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
            res = parent[u][i];
        }
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
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        maxDepth = (int) Math.ceil(Math.log(N) / Math.log(2));
        parent = new int[N + 1][maxDepth + 1];
        depth = new int[N + 1];
        dfs(1, 0);

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());

            // Solve
            sb.append(LCA(u, v)).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}