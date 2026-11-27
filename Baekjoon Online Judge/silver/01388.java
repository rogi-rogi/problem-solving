import java.io.*;

public class Main {
    static char[][] board;
    static int N, M;
    static char VISITED = 'X';

    private static void connect(int x, int y, char type) {
        if (type == '-') {
            for (int ny = y; ny < M; ++ny) {
                if (board[x][ny] == '-') {
                    board[x][ny] = VISITED;
                } else {
                    break;
                }
            }
        } else if (type == '|') {
            for (int nx = x; nx < N; ++nx) {
                if (board[nx][y] == '|') {
                    board[nx][y] = VISITED;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        board = new char[N][M];
        for (int i = 0; i < N; ++i) {
            board[i] = br.readLine().toCharArray();
        }

        // Solve
        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i][j] != VISITED) {
                    ++cnt;
                    connect(i, j, board[i][j]);
                };
            }
        }

        // Output
        System.out.println(cnt);
    }
}