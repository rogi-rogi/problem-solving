import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());

        // Solve
        R *= A;
        C *= B;
        char[][] board = new char[R][C];
        boolean startMark = true, mark = true;

        for (int i = 0; i < R; i += A) {
            for (int j = 0; j < C; j += B) {
                for (int a = 0; a < A; a++) {
                    for (int b = 0; b < B; b++) {
                        board[i + a][j + b] = mark ? 'X' : '.';
                    }
                }
                mark = !mark;
            }
            startMark = !startMark;
            mark = startMark;
        }

        // Output
        for (int i = 0; i < R; ++i) {
            for (char col : board[i]) {
                sb.append(col);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}