import java.io.*;
import java.util.*;

public class Main {
    static long res = 0;
    private static void dfs(List<Integer>[] graph, int parent, int u, long depth) {
        boolean isLeaf = true;
        for (int v : graph[u]) {
            if (v != parent) {
                isLeaf = false;
                dfs(graph, u, v, depth + 1);
            }
        }
        if (isLeaf) {
            res += depth;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        final int N = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());
            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // Solve
        dfs(graph, 1, 1, 0);

        // Output
        System.out.println(res % 2 == 1 ? "Yes" : "No");
    }
}