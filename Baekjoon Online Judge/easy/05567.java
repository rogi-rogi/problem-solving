import java.io.*;
import java.util.*;

public class Main {
    public static int bfs(int[][] graph, int N) {
        int[] visited = new int[N + 1];
        Arrays.fill(visited, 0);
        visited[1] = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int prev = queue.removeFirst();
            if (visited[prev] > 2) continue;
            for (int i = 2; i <= N; ++i) {
                if (graph[prev][i] == 1 && visited[i] == 0) {
                    visited[i] = visited[prev] + 1;
                    queue.addLast(i);
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] graph = new int[N + 1][N + 1];
        int[] node;
        while (M-- > 0) {
            node = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[node[0]][node[1]] = 1;
            graph[node[1]][node[0]] = 1;
        }

        // Solve & Output
        System.out.println(bfs(graph, N));
    }
}
