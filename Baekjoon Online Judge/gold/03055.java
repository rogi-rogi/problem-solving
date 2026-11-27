import java.io.*;
import java.util.*;

public class Main {
    final static char EMPTY = '.', WATER = '*', START = 'S', END = 'D';
    static int[][] D = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
    };
    static int R, C;
    static char[][] board;
    static boolean[][] visited;

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    private static int bfs() {
        Deque<int[]> waterQueue = new ArrayDeque<>();
        Deque<int[]> hedgehogQueue = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == WATER) {
                    waterQueue.add(new int[]{i, j});
                } else if (board[i][j] == START) {
                    hedgehogQueue.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[R][C];
        int time = 0;

        while (!hedgehogQueue.isEmpty()) {
            int waterSize = waterQueue.size();
            while (waterSize-- > 0) {
                int[] cur = waterQueue.poll();
                final int x = cur[0], y = cur[1];
                for (int[] d : D) {
                    final int nx = x + d[0], ny = y + d[1];
                    if (isValid(nx, ny) && board[nx][ny] == EMPTY) {
                        board[nx][ny] = WATER;
                        waterQueue.add(new int[]{nx, ny});
                    }
                }
            }

            int hedgehogSize = hedgehogQueue.size();
            while (hedgehogSize-- > 0) {
                int[] cur = hedgehogQueue.poll();
                final int x = cur[0], y = cur[1];
                for (int[] d : D) {
                    final int nx = x + d[0], ny = y + d[1];
                    if (isValid(nx, ny)) {
                        if (board[nx][ny] == END) {
                            return time + 1;
                        }
                        if (board[nx][ny] == EMPTY && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            board[nx][ny] = START;
                            hedgehogQueue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            ++time;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int result = bfs();
        System.out.println(result == -1 ? "KAKTUS" : result);
    }
}