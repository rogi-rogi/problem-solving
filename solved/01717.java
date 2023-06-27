import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
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
        private boolean union(int u, int v){
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
        StringBuilder sb = new StringBuilder();

        // input
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        DisjointSet set = new DisjointSet(n + 1);
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(bfr.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // solution
            if (type == 0) set.union(a, b);
            else sb.append(set.find(a) == set.find(b) ? "YES" : "NO").append('\n');
        }

        // output
        System.out.println(sb.toString());
    }
}
