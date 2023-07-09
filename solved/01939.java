import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private static class Edge {
        private int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    private static class DisjointSet {
        private final int[] parent, rank;
        DisjointSet(int size) {
            this.parent = new int[size + 1];
            this.rank = new int[size + 1];
            Arrays.setAll(this.parent, i -> i);
            Arrays.fill(this.rank, 0);
        }
        private int find(int v) {
            if (this.parent[v] == v) return v;
            return (this.parent[v] = this.find(this.parent[v]));
        }
        private boolean union(int x, int y) {
            x = this.find(x);
            y = this.find(y);
            if (x != y) {
                if (this.rank[x] < this.rank[y]) this.parent[x] = y;
                else if (this.rank[x] > this.rank[y]) this.parent[y] = x;
                else {
                    this.parent[y] = x;
                    ++this.rank[x];
                }
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
