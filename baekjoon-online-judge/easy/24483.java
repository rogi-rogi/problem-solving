import java.io.*;
import java.util.*;

public class Main {
    static final int NOT_VISITED = -1;
    static int N;
    static List<SortedSet<Integer>> graph;
    static int[] d, t;
    static int no = 1;
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);
        final int R = Integer.parseInt(input[2]);
        graph = new ArrayList<>(N + 1);
        d = new int[N + 1];
        t = new int[N + 1];
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

        // Solve
        Arrays.fill(d, NOT_VISITED);
        dfs(R, 0);

        // Output
        long res = 0;
        for (int i = 1; i <= N; ++i) {
            res += (long) d[i] * t[i];
        }
        System.out.println(res);
    }

    private static void dfs(int start, int depth) {
        d[start] = depth;
        t[start] = no++;
        for (int v : graph.get(start)) {
            if (d[v] == NOT_VISITED) {
                dfs(v, depth + 1);
            }
        }
    }
}
