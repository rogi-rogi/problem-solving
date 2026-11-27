import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void DFS(int x) {
        for (int i : graph[x]) {
            if (visited[i] == -1) {
                visited[i] = visited[x] + 1;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] info = br.readLine().split(" ");
        final int N = Integer.parseInt(info[0]);
        final int M = Integer.parseInt(info[1]);
        final int R = Integer.parseInt(info[2]);

        visited = new int[N + 1];
        Arrays.fill(visited, -1);
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            info = br.readLine().split(" ");
            int u = Integer.parseInt(info[0]);
            int v = Integer.parseInt(info[1]);
            graph[u].add(v);
            graph[v].add(u);
        }
        // Solve
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited[R] = 0;
        DFS(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }

        // Output
        System.out.print(sb);
    }
}
