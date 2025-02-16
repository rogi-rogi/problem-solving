import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][];
        for(int i = 0; i < N; ++i) {
            board[i] = br.readLine().toCharArray();
        }
        final int K = Integer.parseInt(br.readLine());

        // Solve
        switch (K) {
            case 2:
                for (int row = 0; row < N; ++row) {
                    for (int col = 0; col < N / 2; ++col) {
                        char temp = board[row][col];
                        board[row][col] = board[row][N - 1 - col];
                        board[row][N - 1 - col] = temp;
                    }
                }
                break;
            case 3:
                for (int row = 0; row < N / 2; ++row) {
                    for (int col = 0; col < N; ++col) {
                        char temp = board[row][col];
                        board[row][col] = board[N - 1 - row][col];
                        board[N - 1 - row][col] = temp;
                    }
                }
                break;
        }

        // Output
        for (int i = 0; i < N; ++i) {
            sb.append(board[i]).append('\n');
        }
        System.out.println(sb);
    }
}