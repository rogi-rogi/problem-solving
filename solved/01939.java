import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private static class Edge {
        public int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    private static class DisjointSet {
        private final int[] parents;
        DisjointSet(int size) {
            this.parents = new int[size];
            Arrays.setAll(this.parents, i -> i);
        }
        private int find(int v) {
            if (this.parents[v] == v) return v;
            return (this.parents[v] = this.find(this.parents[v]));
        }
        private boolean union(int u, int v) {
            u = this.find(u);
            v = this.find(v);
            if (u != v) {
                this.parents[Math.max(u, v)] = Math.min(u, v);
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());

        // input
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        DisjointSet set = new DisjointSet(N + 1);
        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(bfr.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(A, B, C);
        }
        st = new StringTokenizer(bfr.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        // solution
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.w - o1.w;
            }
        });

        for (Edge edge : edges) {
            set.union(edge.u, edge.v);
            if (set.find(from) == set.find(to)) {
                // output
                System.out.println(edge.w);
                return;
            }
        }
    }
}
