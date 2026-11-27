import java.io.*;
import java.util.*;

public class Main {
    final static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    final static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

    public static int bfs(int[] cur, int[] end) {
        if (Point.isEqual(cur, end)) return 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(cur);
        boolean[][] visited = new boolean[9][9];
        visited[cur[0]][cur[1]] = true;

        int nx, ny;
        int[] next;
        while (!queue.isEmpty()) {
            cur = queue.removeFirst();
            for (int i = 0; i < 8; ++i) {
                nx = cur[0] + dx[i];
                ny = cur[1] + dy[i];
                if (Point.isInArea(nx, ny) && !visited[nx][ny]) {
                    next = new int[]{nx, ny, cur[2] + 1};
                    if (Point.isEqual(next, end)) return next[2];
                    visited[nx][ny] = true;
                    queue.addLast(next);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int[] start = {position[0], position[1], 0};
        position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int[] end = {position[0], position[1]};

        // Solve & Output
        System.out.println(bfs(start, end));
    }
}

class Point {
    public static boolean isInArea(int nx, int ny) {
        return 1 <= nx && nx <= 8
                && 1 <= ny && ny <= 8;
    }
    public static boolean isEqual(int[] cur, int[] end) {
        return cur[0] == end[0] && cur[1] == end[1];
    }
}
