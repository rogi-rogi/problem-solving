import java.io.*;

public class Main {
    static char[][] board;
    private static String solve(int i, int j, int d) {
        final int halfD = d / 2;
        if (board[i][j + halfD] != '#') {
            return "UP";
        } else if (board[i + d - 1][j + halfD] != '#') {
            return "DOWN";
        } else if (board[i + halfD][j] != '#') {
            return "LEFT";
        } else {
            return "RIGHT";
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);

        board = new char[N][M];
        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; ++j) {

                // Solve
                if (board[i][j] == '#') {
                    ++cnt;
                }
            }
        }
        final int d = ((cnt + 1 - 4) / 4) + 2;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i][j] == '#') {
                    // Output
                    System.out.println(solve(i, j, d));
                    return;
                }
            }
        }
    }
}