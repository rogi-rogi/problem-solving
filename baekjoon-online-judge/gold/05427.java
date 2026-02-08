import java.io.*;
import java.util.*;

public class Main {
    final static char BLOCK_CHAR = '#', START_CHAR = '@', FIRE_CHAR = '*';
    final static int BLOCK = -1, EMPTY = 0, START = 1;
    static int W, H;
    static int[][] board;
    static int[][] D = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            H = input[0];
            W = input[1];
            board = new int[W][H];
            Deque<int[]> queue = new ArrayDeque<>();
            int sx = 0, sy = 0;
            for (int i = 0; i < W; ++i) {
                char[] line = br.readLine().toCharArray();
                for (int j = 0; j < H; ++j) {
                    switch (line[j]) {
                        case BLOCK_CHAR -> board[i][j] = BLOCK;
                        case FIRE_CHAR -> {
                            queue.add(new int[]{i, j});
                            board[i][j] = BLOCK;
                        }
                        case START_CHAR -> {
                            sx = i;
                            sy = j;
                            board[i][j] = START;
                        }
                        default -> board[i][j] = EMPTY;
                    }
                }
            }
            queue.add(new int[] {sx, sy});

            // Solve
            int time = bfs(queue, sx, sy);
            sb.append(time >= 0 ? time : "IMPOSSIBLE").append('\n');
        }

        // Output
        System.out.println(sb);
    }
    private static int bfs(Deque<int[]> queue, int sx, int sy) {
        if (sx == 0 || sx == W - 1 || sy == 0 || sy == H - 1) return 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.pop();
            for (int[] d : D) {
                final int nx = cur[0] + d[0];
                final int ny = cur[1] + d[1];
                if (isValid(nx, ny)) {
                    if (board[cur[0]][cur[1]] != BLOCK && (nx == 0 || nx == W - 1 || ny == 0 || ny == H - 1)) {
                        return board[cur[0]][cur[1]] + 1;
                    }
                    board[nx][ny] = board[cur[0]][cur[1]] != BLOCK ? board[cur[0]][cur[1]] + 1 : BLOCK;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < W && y >= 0 && y < H && board[x][y] == EMPTY;
    }
}
