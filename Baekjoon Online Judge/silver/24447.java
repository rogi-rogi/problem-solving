import java.io.*;
import java.util.*;

public class Main {
    static final int NOT_VISITED = -1;
    static int N;
    static List<SortedSet<Integer>> graph;
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);
        final int R = Integer.parseInt(input[2]);
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; ++i) {
            graph.add(new TreeSet<>());
        }
        for (int i = 0; i < M; ++i) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Solve & Output
        System.out.println(bfs(R));
    }
    private static long bfs(int start) {
        int[] d = new int[N + 1];
        int[] t = new int[N + 1];
        Arrays.fill(d, NOT_VISITED);
        int no = 1;
        t[start] = no;
        d[start] = 0;

        Deque<Integer> queue = new ArrayDeque<>(List.of(start));

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer v : graph.get(u)) {
                if (d[v] == NOT_VISITED) {
                    t[v] = ++no;
                    d[v] = d[u] + 1;
                    queue.add(v);
                }
            }
        }
        long sum = 0;
        for (int i = 0; i <= N; ++i) {
            sum += (long) d[i] * t[i];
        }
        return sum;
    }
}
