import java.io.*;
import java.util.*;

public class Main {
    final static char BLOCK_CHAR = '#', START_CHAR = 'S', END_CHAR = 'E';
    final static int BLOCK = -1, EMPTY = 0;
    static int L, R, C;
    static int sl, sr, sc,el, er, ec;
    static int[][][] board;
    static int[][] D = {{0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        while (true) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            L = input[0];
            R = input[1];
            C = input[2];
            board = new int[L][R][C];
            if (L == 0 && R == 0 && C == 0) break;
            for (int l = 0; l < L; ++l) {
                for (int r = 0; r < R; ++r) {
                    char[] row = br.readLine().toCharArray();
                    for (int c = 0; c < C; ++c) {
                        switch (row[c]) {
                            case BLOCK_CHAR:
                                board[l][r][c] = BLOCK;
                                break;
                            case START_CHAR:
                                sl = l;
                                sr = r;
                                sc = c;
                                break;
                            case END_CHAR:
                                el = l;
                                er = r;
                                ec = c;
                                break;
                        }
                    }
                }
                br.readLine();
            }
            // Solve
            int time = bfs();
            sb.append(time >= 0 ? String.format("Escaped in %d minute(s).\n", time) : "Trapped!\n");

        }

        // Output
        System.out.println(sb);
    }
    private static int bfs() {
        Deque<int[]> queue = new ArrayDeque<>(List.of(new int[]{sl, sr, sc}));
        board[sl][sr][sc] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.pop();
            for (int[] d : D) {
                final int nl = cur[0] + d[0];
                final int nr = cur[1] + d[1];
                final int nc = cur[2] + d[2];
                if (0 <= nl && nl < L && 0 <= nr && nr < R && 0 <= nc && nc < C && board[nl][nr][nc] == EMPTY) {
                    if (nl == el && nr == er && nc == ec) return board[cur[0]][cur[1]][cur[2]];
                    board[nl][nr][nc] = board[cur[0]][cur[1]][cur[2]] + 1;
                    queue.add(new int[]{nl, nr, nc});
                }
            }
        }
        return -1;
    }
}
