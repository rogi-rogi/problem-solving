import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static char[][] board;

    private static int solve() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i][j] != 'W') continue;
                for (int d = 0; d < 4; ++d) {
                    final int nx = i + dx[d];
                    final int ny = j + dy[d];
                    if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                        if (board[nx][ny] == 'S') {
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; ++i) {
            board[i] = br.readLine().toCharArray();
        }

        // Solve
        final int res = solve();
        sb.append(res).append("\n");
        if (res == 1) {
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (board[i][j] == '.') {
                        board[i][j] = 'D';
                    }
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        }

        // Output
        System.out.println(sb);
    }
}