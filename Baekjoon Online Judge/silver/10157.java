import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    private static boolean isValid(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }
    private static int[] solve(int K) {
        if (K > R*C) {
            return null;
        }

        int[][] board = new int[R][C];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int d = 0, x = -1, y = 0;
        for (int k = 0; k < K;) {
            int nx = x + dx[d], ny = y + dy[d];
            if (isValid(nx, ny) && board[nx][ny] == 0) {
                board[nx][ny] = ++k;
                x = nx;
                y = ny;
            } else {
                d = (d + 1) % 4;
            }
        }
        return new int[] {y + 1, x + 1};
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        final int K = Integer.parseInt(br.readLine());

        // Solve
        int[] pos = solve(K);

        // Output
        if (pos != null) {
            System.out.println(pos[0] + " " + pos[1]);
        } else {
            System.out.println(0);
        }
    }
}