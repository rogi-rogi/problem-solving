import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] dist, board;

    static class Node {
        int x, y, w;
        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    private static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static int dijkstra() {
        dist = new int[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        pq.add(new Node(0, 0, board[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.x][cur.y] < cur.w) continue;
            for (int d = 0; d < 4; ++d) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (isValid(nx, ny) && cur.w + board[nx][ny] < dist[nx][ny]) {
                    dist[nx][ny] = cur.w + board[nx][ny];
                    pq.add(new Node(nx, ny, dist[nx][ny]));
                }
            }
        }
        return dist[N - 1][N - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        for (int TC = 1; (N = Integer.parseInt(br.readLine())) != 0; ++TC) {
            board = new int[N][N];
            for (int i = 0; i < N; ++i) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            // Solve
            sb.append("Problem ").append(TC).append(": ")
                    .append(dijkstra())
                    .append("\n");
        }

        // Output
        System.out.println(sb);
    }
}
