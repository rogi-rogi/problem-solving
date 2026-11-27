import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class DisjointSet {
        final int[] parent, rank;
        DisjointSet(int n) {
            this.parent = new int[n + 1];
            this.rank = new int[n + 1];
            Arrays.setAll(this.parent, i -> i);
            Arrays.fill(this.rank, 0);
        }
        private int find(int x) {
            if (x != this.parent[x])
                return (this.parent[x] = this.find(this.parent[x]));
            return x;
        }
        private boolean union(int x, int y) {
            x = this.find(x);
            y = this.find(y);
            if (x != y) {
                if (this.rank[x] < this.rank[y]) {
                    this.parent[x] = y;
                } else if (this.rank[x] > this.rank[y]) {
                    this.parent[y] = x;
                } else {
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        DisjointSet set = new DisjointSet(n + 1);
        int res = 0;
        for (int i = 1; i <= m; ++i) {
            st = new StringTokenizer(bfr.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // solution
            if (!set.union(x, y)) {
                res = i;
                break;
            }
        }

        // output
        System.out.println(res);
    }
}
