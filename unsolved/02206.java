import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ02206 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static int[][] board;
    static int[][][] visited;
    private static class Point {
        private int wall, x, y;
        Point(int wall, int x, int y) {
            this.wall = wall;
            this.x = x;
            this.y = y;
        }
    }

    private static int bfs() {
        visited[0][0][0] = 1;
        Deque<Point> queue = new ArrayDeque<Point>();
        queue.add(new Point(0, 0, 0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int wall = p.wall;
            int x = p.x;
            int y = p.y;
            if (x == N - 1 && y == M - 1) return visited[wall][x][y];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && visited[wall][nx][ny] == 0) {
                    if (board[nx][ny] == 0) {
                        queue.offer(new Point(wall, nx, ny));
                        visited[wall][nx][ny] = visited[wall][x][y] + 1;
                    } else if (wall == 0){ // && board[nx][ny] == 1
                        queue.offer(new Point(1, nx, ny));
                        visited[1][nx][ny] = visited[0][x][y] + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());

        // input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new int[2][N][M];
        for (int i = 0; i < N; ++i) {
            String line = bfr.readLine();
            for (int j = 0; j < M; ++j)
                board[i][j] = line.charAt(j) - '0';
        }

        // solution output
        System.out.println(bfs());
    }
}
