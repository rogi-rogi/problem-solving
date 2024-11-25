import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> graph;
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
        for (int i = 0; i <= N; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; ++i) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
          
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Solve
        graph.forEach(Collections::sort);

        int[] visited = bfs(R);
        for (int i = 1; i <= N; ++i) {
            sb.append(visited[i]).append('\n');
        }

        // Output
        System.out.println(sb);
    }
    private static int[] bfs(int start) {
        int[] visited = new int[N + 1];
        int no = 1;
        visited[start] = no;

        Deque<Integer> queue = new ArrayDeque<>(List.of(start));

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer v : graph.get(u)) {
                if (visited[v] == 0) {
                    visited[v] = ++no;
                    queue.add(v);
                }
            }
        }
        return visited;
    }
}
