import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        final int a = Integer.parseInt(st.nextToken());
        final int b = Integer.parseInt(st.nextToken());

        // Solve
        char[][] board = new char[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (i < a) {
                    board[i][j] = 'S';
                } else if (i > a) {
                    board[i][j] = 'N';
                } else if (j < b) {
                    board[i][j] = 'E';
                } else if (j > b) {
                    board[i][j] = 'W';
                }
            }
        }
        board[a][b] = 'S';

        // Output
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}