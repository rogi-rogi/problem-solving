import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int NOT_VISITED = 0, RED = 1, GREEN = 2;
    static int[] dx = {-1, -1, 0, 1, 1, 0}, dy = {0, 1, 1, 0, -1, -1};
    static char[][] board;
    static int[][] visited;

    private static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static int dfs(int x, int y, int mark) {
        visited[x][y] = mark;
        int cnt = mark;

        for (int d = 0; d < 6; ++d) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (!isValid(nx, ny))
                continue;
            if (board[nx][ny] == 'X' && visited[nx][ny] == NOT_VISITED) {
                cnt = Math.max(cnt, dfs(nx, ny, mark == RED ? GREEN : RED));
            }
            if (visited[nx][ny] == mark) {
                // visited[nx][ny] is BLUE
                return 3;
            }
        }
        return cnt;
    }
    /*
    private static int bfs(int x, int y) {
        visited[x][y] = RED;
        int cnt = RED;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 6; ++d) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (!isValid(nx, ny))
                    continue;
                if (board[nx][ny] == 'X' && visited[nx][ny] == NOT_VISITED) {
                    visited[nx][ny] = visited[cur[0]][cur[1]] == RED ? GREEN : RED;
                    queue.add(new int[]{nx, ny});
                    cnt = GREEN;
                }
                if (visited[nx][ny] == visited[cur[0]][cur[1]]) {
                    // visited[nx][ny] is BLUE
                    return 3;
                }
            }
        }
        return cnt;
    }
     */

    private static int solve() {
        int result = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (board[i][j] == 'X' && visited[i][j] == NOT_VISITED) {
                    result = Math.max(result, dfs(i, j, RED));
                    if (result == 3) {
                        return 3;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; ++i) {
            board[i] = br.readLine().toCharArray();
        }

        // Solve & Output
        System.out.println(solve());
    }
}