import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, r, MAX = 99*15;
    private static int[] item;
    private static int[][] graph;
    private static int floydWarshall() {
        for (int t = 1; t <= n; ++t) {
            for (int u = 1; u <= n; ++u) {
                for (int v = 1; v <= n; ++v) {
                    if (u != v) {
                        int w = graph[u][t] + graph[t][v];
                        if (w < graph[u][v]) graph[u][v] = w;
                    }
                }
            }
        }

        int itemCnt = 0;
        for (int i = 1; i <= n; ++i) {
            int sum = 0;
            for (int j = 1; j <= n; ++j) {
                if (graph[i][j] != MAX && graph[i][j] <= m) sum += item[j];
            }
            if (sum > itemCnt) itemCnt = sum;
        }
        return itemCnt;
    }

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());

        // input
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        item = new int[n + 1];
        graph = new int[n + 1][n + 1];
        st = new StringTokenizer(bfr.readLine());
        for (int i = 1; i <= n; ++i) {
            item[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(graph[i], MAX);
            graph[i][i] = 0;
        }
        for (int i = 0; i < r; ++i) {
            st = new StringTokenizer(bfr.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u][v] = w;
            graph[v][u] = w;
        }

        // solution & output
        System.out.println(floydWarshall());
    }
}
