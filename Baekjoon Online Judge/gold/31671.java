import java.io.*;

public class Main {
    static int N;
    private static boolean isValid(int x, int y) {
        if (x < 0 || x > 2 * N || y < 0 || y > N) return false;
        if (x <= N) {
            return y <= x;
        }
        return y <= 2 * x - x;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        final int WIDTH = 2*N + 1;
        final int HEIGHT = N + 1;
        final int L = 0, R = 1;
        boolean[][] forbidden = new boolean[WIDTH][HEIGHT];

        while (M-- > 0) {
            input = br.readLine().split(" ");
            final int x = Integer.parseInt(input[0]);
            final int y = Integer.parseInt(input[1]);
            forbidden[x][y] = true;
        }

        // Solve
        boolean[][][] dp = new boolean[2][WIDTH][HEIGHT];
        int[] D = new int[] {-1, 1};
        dp[L][0][0] = true;
        for (int x = 0; x < WIDTH - 1; ++x) {
            for (int y = 0; y <= HEIGHT - 1; ++y) {
                if (!dp[L][x][y]) {
                    continue;
                }
                for (int dy : D) {
                    final int nx = x + 1;
                    final int ny = y + dy;
                    if (isValid(nx, ny) && !forbidden[nx][ny]) {
                        dp[L][nx][ny] = true;
                    }
                }
            }
        }
        dp[R][2*N][0] = true;
        for (int x = WIDTH - 1; x >= 1; --x) {
            for (int y = 0; y <= HEIGHT - 1; ++y) {
                if (!dp[R][x][y]) {
                    continue;
                }
                for (int dy : D) {
                    final int nx = x - 1;
                    final int ny = y + dy;
                    if (isValid(nx, ny) && !forbidden[nx][ny]) {
                        dp[R][nx][ny] = true;
                    }
                }
            }
        }

        int maxY = -1;
        for (int x = 0; x < WIDTH; ++x) {
            for (int y = 0; y < HEIGHT; ++y) {
                if (dp[L][x][y] && dp[R][x][y]) {
                    maxY = Math.max(maxY, y);
                }
            }
        }

        // Output
        System.out.println(maxY);
    }
}