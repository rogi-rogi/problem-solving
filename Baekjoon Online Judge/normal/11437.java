import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> tree;
    static int[] parent, depth;

    private static void dfs(int node, int parentNode) {
        parent[node] = parentNode;
        depth[node] = depth[parentNode] + 1;
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
        while (depth[v] > depth[u]) {
            v = parent[v];
        }
        while (u != v) {
            u = parent[u];
            v = parent[v];
        }
        return u;
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


        parent = new int[N + 1];
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