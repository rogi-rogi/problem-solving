import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static class DisjointSet {
        private final int[] parents;
        private final int[] count;
        DisjointSet(int size) {
            this.parents = new int[size * 2];
            this.count = new int[size * 2];
            Arrays.setAll(this.parents, i -> i);
            Arrays.fill(this.count, 1);
        }
        private int find(int v) {
            if (this.parents[v] == v) return v;
            return (this.parents[v] = this.find(this.parents[v]));
        }
        private int union(int u, int v) {
            u = this.find(u);
            v = this.find(v);
            if (u != v) {
                this.parents[Math.max(u, v)] = Math.min(u, v);
                return (this.count[Math.min(u, v)] += this.count[Math.max(u, v)]);
            }
            return this.count[u];
        }
    }

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> nameDict = new HashMap();

        // input
        int TC = Integer.parseInt(bfr.readLine());
        while (TC-- > 0) {
            int num = -1;
            int F = Integer.parseInt(bfr.readLine());
            DisjointSet set = new DisjointSet(F);
            for (int i = 0; i < F; ++i) {
                st = new StringTokenizer(bfr.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                // solution
                if (!nameDict.containsKey(name1))
                    nameDict.put(name1, ++num);
                if (!nameDict.containsKey(name2))
                    nameDict.put(name2, ++num);
                sb.append(set.union(nameDict.get(name1), nameDict.get(name2))).append('\n');
            }
        }

        // output
        System.out.println(sb.toString());
    }
}
