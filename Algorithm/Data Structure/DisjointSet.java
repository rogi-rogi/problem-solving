import java.util.Arrays;

public class DisjointSet {
    private final int[] parent;
    private final int[] rank;
    private final int[] size;
    DisjointSet(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.size = new int[n];
        Arrays.setAll(this.parent, i -> i);
        Arrays.fill(this.parent, 0);
        Arrays.fill(this.size, 1);
    }
    public int findPathCompression(int x) {
        if (this.parent[x] != x)
            return (this.parent[x] = this.findPathCompression(this.parent[x]));
        return x;
    }
    public int findPathHalving(int x) {
        while (this.parent[x] != x) {
            this.parent[x] = this.parent[this.parent[x]];
            x = this.parent[x];
        }
        return x;
    }
    public int findPathSplitting(int x) {
        while (this.parent[x] != x) {
            int next = this.parent[x];
            this.parent[x] = this.parent[this.parent[x]];
            x = next;
        }
        return x;
    }

    public boolean unionByRank(int x, int y) {
        x = this.findPathCompression(x);
        y = this.findPathCompression(y);
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

    public boolean unionBySize(int x, int y) {
        x = this.findPathCompression(x);
        y = this.findPathCompression(y);
        if (x != y) {
            if (this.size[x] < this.size[y]) {
                this.parent[x] = y;
                this.size[y] += this.size[x];
            }
            else {
                this.parent[y] = x;
                this.size[x] += this.size[y];
            }
            return true;
        }
        return false;
    }
}

