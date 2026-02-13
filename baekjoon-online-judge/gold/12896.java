import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int maxDist, node = -1;

    private static void dfs(int start, int depth) {
        visited[start] = true;

        if (depth > maxDist) {
            maxDist = depth;
            node = start;
        }

        for (int next : graph[start]) {
            if (!visited[next]) dfs(next, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        for (int i = 0; i < N; ++i) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        // Solve
        visited = new boolean[N];
        maxDist = -1;
        dfs(0, 0);
        visited = new boolean[N];
        maxDist = -1;
        dfs(node, 0);

        // Output
        System.out.println((maxDist + 1) / 2);
    }
}
