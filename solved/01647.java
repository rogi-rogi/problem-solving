import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static Edge[] graph;
    private static int[] parents;
  
    private static class DisjointSet {
        private int find(int v) {
            if (parents[v] == v) return v;
            return (parents[v] = this.find(parents[v]));
        }
        private boolean union(int u, int v){
            u = this.find(u);
            v = this.find(v);
            if (u != v) {
                parents[Math.max(u, v)] = Math.min(u, v);
                return true;
            }
            return false;
        }
    }
  
    private static class Edge {
        private int u, v, w;
        private Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
  
    private static int Kruskal(){
        if (N == 2) return 0;
        int MST_weight = 0, connected = 0;
        DisjointSet set = new DisjointSet();
        for (Edge edge : graph) {
            if (set.union(edge.u, edge.v)) {
                MST_weight += edge.w;
                connected += 1;
                if (connected >= N - 2) break;
            }
        }
        return MST_weight;
    }

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());

        // input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new Edge[M];
        parents = new int[N + 1];
        Arrays.setAll(parents, i -> i);

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(bfr.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[i] = new Edge(u, v, w);
        }
        Arrays.sort(graph, (o1, o2) -> {
            return Integer.compare(o1.w, o2.w);
        });
        
        // output
        System.out.println(Kruskal());
    }
}
