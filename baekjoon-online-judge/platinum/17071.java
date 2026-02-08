import java.io.*;
import java.util.*;

public class Main {
    final static int MAX = 500_000;
    static boolean[][] visited = new boolean[2][MAX + 1];
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int N = input[0];
        final int K = input[1];

        // Solve & Output
        System.out.println(bfs(N, K));
    }
    private static int bfs(int n, int k) {
        if (n == k) return 0;
        Deque<Integer> queue = new ArrayDeque<>(List.of(n));
        int step = 0;
        while (!queue.isEmpty() && (k += ++step) <= MAX) {
            if (visited[step % 2][k]) return step;
            final int curStepQueueSize = queue.size();
            for (int i = 0; i < curStepQueueSize; ++i) {
                int cur = queue.pop();
                for (int next : List.of(cur - 1, cur + 1, 2 * cur)) {
                    if (0 <= next && next <= MAX && !visited[step % 2][next]) {
                        if (next == k) return step;
                        visited[step % 2][next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return -1;
    }
}
