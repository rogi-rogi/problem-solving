import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int N, M;;
    static char[][] board;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static int isCross(int x, int y, int size) {
        for (int d = 0; d < 4; ++d) {
            final int nx = x + dx[d] * size;
            final int ny = y + dy[d] * size;
            if (!isValid(nx, ny) || board[nx][ny] == '.') {
                return size - 1;
            }
        }
        for (int d = 0; d < 4; ++d) {
            final int nx = x + dx[d] * size;
            final int ny = y + dy[d] * size;
            visited[nx][ny] = true;
        }

        sb.append(x + 1).append(" ").append(y + 1).append(" ").append(size).append("\n");
        return isCross(x, y, size + 1);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; ++i) {
            board[i] = br.readLine().toCharArray();
        }

        // Solve
        visited = new boolean[N][M];
        boolean hasStar = false;
        long cnt = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i][j] == '*') {
                    hasStar = true;
                    long size = isCross(i, j, 1);
                    if (size > 0) {
                        visited[i][j] = true;
                        cnt += size;
                    }
                }
            }
        }

        // Output
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i][j] == '*' && !visited[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt == 0 && hasStar ? -1 : cnt);
        System.out.println(sb);
    }
}