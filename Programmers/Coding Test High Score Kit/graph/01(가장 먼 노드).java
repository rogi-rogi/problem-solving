/*
가장 먼 노드
https://school.programmers.co.kr/learn/courses/30/lessons/49189
*/
import java.util.*;

class Solution {
    final static int NOT_VISITED = -1;
    
    public int solution(int n, int[][] edge) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            graph.add(new TreeSet<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        return bfs(graph, n);
    }
    private int bfs(List<Set<Integer>> graph, int n) {
        int[] visited = new int[n + 1];
        Arrays.fill(visited, NOT_VISITED);
        visited[1] = 0;
        Deque<Integer> queue = new ArrayDeque<>(List.of(1));
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer v : graph.get(u)) {
                if (visited[v] == NOT_VISITED) {
                    visited[v] = visited[u] + 1;
                    if (visited[v] > maxDepth) {
                        maxDepth = visited[v];
                    }
                    queue.add(v);
                }
            }
        }
        int cnt = 0;
        for (int depth : visited) {
            if (depth == maxDepth) {
                ++cnt;
            }
        }
        return cnt;
    }
}
