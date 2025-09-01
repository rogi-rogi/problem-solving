import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[] P;

    private static int bfs() {
        if (N == 0 && M != 0) return -1;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0 });
        int[] visited = new int[20001];
        Arrays.fill(visited, (int) 2e4);
        visited[10000] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            final int n = cur[0];
            final int m = cur[1];
            if (m == M) {
                return n;
            }
            for (int i = 0; i < N; ++i) {
                final int nextN = n + 1;
                final int nextM = m + P[i];
                if (nextM >= -10000 && nextM <= 10000 && visited[nextM + 10000] > nextN) {
                    queue.add(new int[] { nextN, nextM });
                    visited[nextM + 10000] = nextN;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if (N > 0) {
            P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Solve
            Arrays.sort(P);
        }

        // Output
        System.out.println(bfs());
    }
}