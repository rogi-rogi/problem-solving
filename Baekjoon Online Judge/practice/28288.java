import java.io.*;
import java.util.*;

public class Main {
    final static int COL_CNT = 5;
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner(",");


        // Input
        final int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][];
        for (int i = 0; i < N; ++i) {
            board[i] = br.readLine().toCharArray();
        }


        // Solve
        int[] cnt = new int[COL_CNT];
        int max = 0;
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < COL_CNT; ++col) {
                if (board[row][col] == 'Y') {
                    ++cnt[col];
                    if (cnt[col] > max) {
                        max = cnt[col];
                    }
                }
            }
        }

        for (int col = 0; col < COL_CNT; ++col) {
            if (cnt[col] == max) {
                sj.add(String.valueOf(col + 1));
            }
        }

        // Output
        System.out.println(sj);
    }
}
