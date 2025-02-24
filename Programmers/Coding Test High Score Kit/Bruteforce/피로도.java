// https://school.programmers.co.kr/learn/courses/30/lessons/87946?language=java
// 피로도.java

class Solution {
    int N, cnt;
    int[][] arr;
    boolean[] visited;
    private int dfs(int curK, int depth) {
        int cnt = depth;
        for (int i = 0; i < N; ++i) {
            if (arr[i][0] <= curK && !visited[i]) {
                visited[i] = true;
                cnt = Math.max(cnt, dfs(curK - arr[i][1], depth + 1));
                visited[i] = false;
            }
        }
        return cnt;
    }
    public int solution(int k, int[][] dungeons) {
        arr = dungeons;
        N = dungeons.length;
        visited = new boolean[N];
        int res = 0;
        for (int i = 0; i < N; ++i) {
            if (arr[i][0] <= k) {
                visited[i] = true;
                res = Math.max(res, dfs(k - arr[i][1], 1));
                visited[i] = false;
            }
        }
        return res;
    }
}
