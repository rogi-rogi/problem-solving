import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static int[][] W;
    static int res = Integer.MAX_VALUE;

    private static void permutation(int cur, int cost, int cnt) {
        if (cnt == N && W[cur][1] > 0) {
            res = Math.min(res, cost + W[cur][1]);
        }
        for (int next = 2; next <= N; ++next) {
            if (!visited[next] && W[cur][next] > 0) {
                visited[next] = true;
                permutation(next, cost + W[cur][next], cnt + 1);
                visited[next] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        N = Integer.parseInt(br.readLine());
        W = new int[N + 1][N + 1];
        int[] line;
        for (int i = 1; i <= N; ++i) {
            line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= N; ++j)
                W[i][j] = line[j - 1];
        }

        // Solve
        visited = new boolean[N + 1];
        permutation( 1,0, 1);

        // Output
        System.out.println(res);
    }
}
