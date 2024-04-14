import java.io.*;

public class Main {
    private static final int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    
    private static int eatCandy(char[][] board, int N) {
        int maxEat = 1;
        for (int row = 0; row < N; ++row) {
            int eat = 1;
            for (int col = 1; col < N; ++col) {
                if (board[row][col] == board[row][col - 1]) {
                    ++eat;
                    if (eat > maxEat) maxEat = eat;
                } else eat = 1;
            }
        }
        for (int col = 0; col < N; ++col) {
            int eat = 1;
            for (int row = 1; row < N; ++row) {
                if (board[row][col] == board[row - 1][col]) {
                    ++eat;
                    if (eat > maxEat) maxEat = eat;
                } else eat = 1;
            }
        }
        return maxEat;
    }

    private static boolean isInArea(int x, int y, int N) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static void swap(int x1, int y1, int x2, int y2, char[][] board) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        for (int i = 0; i < N; ++i) {
            String line = br.readLine();
            for (int j = 0; j < N; ++j) {
                board[i][j] = line.charAt(j);
            }
        }

        // Solve
        int res = 0;
        for (int x = 0; x < N; ++x) {
            for (int y = 0; y < N; ++y) {
                for (int d = 0; d < 4; ++d) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (isInArea(nx, ny, N)) {
                        swap(x, y, nx, ny, board);
                        res = Math.max(res, eatCandy(board, N));
                        swap(nx, ny, x, y, board);
                    }
                }
            }
        }

        // Output
        System.out.println(res);
    }
}
