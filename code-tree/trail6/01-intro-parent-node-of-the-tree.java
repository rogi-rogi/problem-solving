// 트리의 부모 노드

import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int N;
    static List<List<Integer>> tree;
    private static void dfs(int node) {
        for (int child : tree.get(node)) {
            if (parent[child] == -1) {
                parent[child] = node;
                dfs(child);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; ++i) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            tree.get(input[0]).add(input[1]);
            tree.get(input[1]).add(input[0]);
        }

        // Solve
        parent = new int[N + 1];
        Arrays.fill(parent, -1);
        dfs(1);

        // Output
        for (int i = 2; i <= N; ++i) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
}