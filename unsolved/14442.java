import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int N, M, K;
    static boolean[][] board;
    static boolean[][][] visited;
    private static class Point {
        private int x, y, dist, smash;
        Point(int x, int y, int dist, int smash) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.smash = smash;
        }
    }

    private static int bfs() {
        visited[0][0][0] = true;
        Deque<Point> queue = new ArrayDeque<Point>();
        queue.add(new Point(0, 0, 1, 0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            int dist = p.dist;
            int smash = p.smash;
            if (x == N - 1 && y == M - 1) return dist;
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[smash][nx][ny]) {
                    if (board[nx][ny]) {
                        queue.offer(new Point(nx, ny, dist + 1, smash));
                        visited[smash][nx][ny] = true;
                    } else if (smash + 1 <= K && !visited[smash + 1][nx][ny]){ // && board[nx][ny] == 1
                        queue.offer(new Point(nx, ny, dist + 1, smash + 1));
                        visited[smash + 1][nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());

        // input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];
        visited = new boolean[K+1][N][M];
        for (int i = 0; i < N; ++i) {
            String line = bfr.readLine();
            for (int j = 0; j < M; ++j)
                board[i][j] = line.charAt(j) - '0' == 0;
        }

        // solution output
        System.out.println(bfs());
    }
}
