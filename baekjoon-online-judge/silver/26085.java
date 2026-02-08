import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    private static int solve() {
        if (N * M % 2 == 1) {
            return -1;
        }
        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i][j] == 0) {
                    ++cnt;
                }
            }
        }
        if (cnt % 2 == 1) {
            return -1;
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if ((j + 1 < M && board[i][j + 1] == board[i][j])
                        || (i + 1 < N && board[i + 1][j] == board[i][j])) {
                    return 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        board = new int[N][M];
        for (int i = 0; i < N; ++i) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // Solve & Output
        System.out.println(solve());
    }
}