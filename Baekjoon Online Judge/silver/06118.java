import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int N;
    static int[] depth;

    private static void bfs() {
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        Deque<Integer> queue = new ArrayDeque<>(List.of(1));

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    depth[next] = depth[cur] + 1;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        depth = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            graph.add(new ArrayList<>());
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);

        }

        // Solve
        bfs();

        int maxDepth = 0;
        for (int d : depth) {
            maxDepth = Math.max(maxDepth, d);
        }

        int no = -1;
        int cnt = 0;
        for (int i = 1; i <= N; ++i) {
            if (depth[i] == maxDepth) {
                ++cnt;
                if (no == -1) no = i;
            }
        }

        // Output
        System.out.printf("%d %d %d", no, depth[no], cnt);
    }
}