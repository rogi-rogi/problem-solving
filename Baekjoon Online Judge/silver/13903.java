import java.io.*;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int R, C;
    static long[][] board;
    static Point[] D;
    private static boolean isValid(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C && board[x][y] == 1;
    }
    private static long bfs() {
        Deque<Point> queue = new ArrayDeque<>();
        long[][] visited = new long[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(visited[i], Long.MAX_VALUE);
        }
        for (int i = 0; i < C; ++i) {
            if (board[0][i] == 1) {
                queue.add(new Point(0, i));
                visited[0][i] = 0;
            }
        }
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (Point d : D) {
                final int nx = cur.x + d.x;
                final int ny = cur.y + d.y;
                if (isValid(nx, ny)) {
                    if (visited[cur.x][cur.y] + 1 < visited[nx][ny]) {
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < C; ++i) {
            if (board[R - 1][i] == 1) {
                res = Math.min(res, visited[R - 1][i]);
            }
        }
        return res == Long.MAX_VALUE ? -1 : res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new long[R][C];
        for (int i = 0; i < R; ++i) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }
        final int N = Integer.parseInt(br.readLine());
        D = new Point[N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            D[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // Solve & Output
        System.out.println(bfs());
    }
}