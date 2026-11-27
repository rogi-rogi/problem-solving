import java.io.*;
import java.util.*;

public class Main {
    static List<List<int[]>> tree;
    static int[] depth, distance;
    static int[][] parent;
    static int maxDepth;

    private static void dfs(int[] cur, int _parent) {
        depth[cur[0]] = depth[_parent] + 1;
        parent[cur[0]][0] = _parent;
        distance[cur[0]] = distance[_parent] + cur[1];
        for (int k = 1; k <= maxDepth; ++k) {
            parent[cur[0]][k] = parent[parent[cur[0]][k - 1]][k - 1];
        }
        for (int[] child : tree.get(cur[0])) {
            if (child[0] != _parent) {
                dfs(child, cur[0]);
            }
        }
    }

    private static int LCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        for (int k = maxDepth; k >= 0; --k) {
            if (depth[parent[u][k]] >= depth[v]) {
                u = parent[u][k];
            }
        }
        if (u == v) return u;
        for (int k = maxDepth; k >= 0; --k) {
            if (parent[u][k] != parent[v][k]) {
                u = parent[u][k];
                v = parent[v][k];
            }
        }
        return parent[u][0];
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
        distance = new int[N + 1];
        dfs(new int[] {1, 0}, 0);

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());

            // Solve
            sb.append(distance[u] + distance[v] - 2 * distance[LCA(u, v)]).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}