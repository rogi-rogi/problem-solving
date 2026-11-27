import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static int N;
    private static int LCA(int u, int v) {
        boolean[] visited = new boolean[N + 1];
        while (u > 0) {
            visited[u] = true;
            u = parent[u];
        }
        while (!visited[v]) {
            v = parent[v];
        }
        return v;
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());

        // Solve
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            for (int i = 0; i < N - 1; ++i) {
                st = new StringTokenizer(br.readLine());
                final int A = Integer.parseInt(st.nextToken());
                final int B = Integer.parseInt(st.nextToken());

                // Solve
                parent[B] = A;
            }
            st = new StringTokenizer(br.readLine());
            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());

            sb.append(LCA(u, v)).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}