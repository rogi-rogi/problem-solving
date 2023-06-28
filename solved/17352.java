import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    private static class DisjoinSet {
        private final int[] parents;
        DisjoinSet(int size) {
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
        StringTokenizer st;
	    
        // input & solution
        int N = Integer.parseInt(bfr.readLine());
        DisjoinSet set = new DisjoinSet(N + 1);
        for (int i = 0; i < N - 2; ++i) {
            st = new StringTokenizer(bfr.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            set.union(a, b);
        }
    
        // output
        for (int i = 1; i < N; ++i) {
            if (set.find(i) != set.find(i + 1)) {
                System.out.printf("%d %d", i, i + 1);
                break;
            }
        }
    }
}

