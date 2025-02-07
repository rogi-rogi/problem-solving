import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int N;
    static int[] cnt;
    private static void bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        Deque<Integer> queue = new ArrayDeque<>(List.of(start));

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    ++cnt[next];
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
        cnt = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            graph.add(new ArrayList<>());
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        // Solve
        for (int i = 1; i <= N; ++i) {
            bfs(i);
        }
        int max = 0;
        for (int num : cnt) {
            max = Math.max(max, num);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= N; ++i) {
            if (cnt[i] == max) {
                res.add(i);
            }
        }
        Collections.sort(res);

        // Output
        System.out.println(res.toString().replaceAll("[\\[|\\],]", ""));
    }
}