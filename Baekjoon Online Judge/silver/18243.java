import java.io.*;
import java.util.*;

public class Main {
    static final int INF = (int) 1e9;
    private static int floydWarshall(int[][] graph, int N) {
        for (int k = 1; k <= N; ++k) {
            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= N; ++i) {
            for (int j = i; j <= N; ++j) {
                res = Math.max(res, graph[i][j]);
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; ++i) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int A = Integer.parseInt(st.nextToken());
            final int B = Integer.parseInt(st.nextToken());
            graph[A][B] = 1;
            graph[B][A] = 1;
        }

        // Solve & Output
        System.out.println(floydWarshall(graph, N) <= 6 ? "Small World!" : "Big World!");
    }
}