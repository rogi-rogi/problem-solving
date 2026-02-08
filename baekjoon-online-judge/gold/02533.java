import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] dp;
    static boolean[] visited;
    static final int EARLY = 1, GENERAL = 0;
    private static void dfs(int cur) {
        visited[cur] = true;
        dp[EARLY][cur] = 1;
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next);
                dp[EARLY][cur] += Math.min(dp[EARLY][next], dp[GENERAL][next]);
                dp[GENERAL][cur] += dp[EARLY][next];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        final int N = Integer.parseInt(br.readLine());
        dp = new int[2][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());
            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Solve
        final int root = 1;
        dfs(root);

        // Output
        System.out.println(Math.min(dp[EARLY][root], dp[GENERAL][root]));
    }
}