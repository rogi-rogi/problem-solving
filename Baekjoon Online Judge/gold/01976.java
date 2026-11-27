import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ01976 {
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
        StringTokenizer st;

        // input
        int N = Integer.parseInt(bfr.readLine());
        int M = Integer.parseInt(bfr.readLine());
        DisjointSet set = new DisjointSet(N + 1);
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(bfr.readLine());
            for (int j = 1; j <= N; ++j)
                if (st.nextToken().equals("1")) set.union(i, j);
        }
        st = new StringTokenizer(bfr.readLine());

        // solution
        String res = "YES";
        int curCity = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; ++i) {
            int nextCity = Integer.parseInt(st.nextToken());
            if (set.find(curCity) != set.find(nextCity)) {
                res = "NO";
                break;
            }
            curCity = nextCity;
        }

        // output
        System.out.println(res);
    }
}
