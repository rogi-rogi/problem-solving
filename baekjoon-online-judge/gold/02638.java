import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int N, M;
    private static int [][] board;
    private static class Point {
        private int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
  
    private static int bfs() {
        Deque<Point> queue = new ArrayDeque<>();
        board[0][0] = -1;
        queue.offer(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int d = 0; d < 4; ++d) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (board[nx][ny] == 0) {
                        board[nx][ny] = -1;
                        queue.offer(new Point(nx, ny));
                    } else if (board[nx][ny] >= 1) ++board[nx][ny];
                }
            }
        }
        int melt = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i][j] != 0) {
                    if (board[i][j] == -1) ++board[i][j];
                    else if (board[i][j] == 2) --board[i][j];
                    else if (board[i][j] >= 3) {
                        board[i][j] = 0;
                        ++melt;
                    }
                }
            }
        }
        return melt;
    }
  
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int cheese = 0;

        // input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; ++i) {
            String line = bfr.readLine();
            for (int j = 0, idx = 0; j < M; ++j, idx += 2) {
                board[i][j] = line.charAt(idx) - '0';
            }
        }

        // solution
        int time = 0;
        for (; bfs() > 0; ++time);

        // output
        System.out.println(time);
    }
}
