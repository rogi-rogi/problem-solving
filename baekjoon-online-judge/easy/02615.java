import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    private static boolean isValid(int x, int y) {
        return 0 <= x && x < 19 && 0 <= y && y < 19;
    }
    private static int whoWin(int x, int y) {
        final int start = board[x][y];
        int[][] dirs = {
                {-1, 1}, // ↗
                {0, 1},  // →
                {1, 1},  // ↘
                {1, 0}   // ↓
        };
        for (int d = 0; d < 4; ++d) {
            int dx = dirs[d][0];
            int dy = dirs[d][1];

            boolean valid = true;

            // 5개 연속 확인
            for (int i = 0; i < 5; ++i) {
                int nx = x + dx * i;
                int ny = y + dy * i;
                if (!isValid(nx, ny) || board[nx][ny] != start) {
                    valid = false;
                    break;
                }
            }
            if (!valid) continue;

            // 6번째 돌 체크
            int prevX = x - dx;
            int prevY = y - dy;
            int nextX = x + dx * 5;
            int nextY = y + dy * 5;

            boolean before = !isValid(prevX, prevY) || board[prevX][prevY] != start;
            boolean after  = !isValid(nextX, nextY) || board[nextX][nextY] != start;

            if (before && after) {
                return start;
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        board = new int[19][19];
        for (int i = 0; i < 19; ++i) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // Solve
        int res = 0;
        for (int i = 0; i < 19; ++i) {
            for (int j = 0; j < 19; ++j) {
                if (board[i][j] == 0) {
                    continue;
                }
                res = whoWin(i, j);
                if (res != 0) {
                    sb.append(res).append("\n").append(i + 1).append(" ").append(j + 1);
                    i = 20;
                    break;
                }
            }
        }
        if (res == 0) {
            sb.append(0);
        }

        // Output
        System.out.println(sb);
    }
}