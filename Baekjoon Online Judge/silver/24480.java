import java.io.*;
import java.util.*;

public class Main {
    static final int NOT_VISITED = 0;
    static int N;
    static List<SortedSet<Integer>> graph;
    static int[] visited;
    static int no = 1;
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);
        final int R = Integer.parseInt(input[2]);
        graph = new ArrayList<>(N + 1);
        visited = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            graph.add(new TreeSet<>(Collections.reverseOrder()));
        }
        for (int i = 0; i < M; ++i) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Solve
        dfs(R);

        // Output
        for (int i = 1; i <= N; ++i) {
            sb.append(visited[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int start) {
        visited[start] = no++;
        for (int v : graph.get(start)) {
            if (visited[v] == NOT_VISITED) {
                dfs(v);
            }
        }
    }
}
