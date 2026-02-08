import java.io.*;
import java.util.*;

public class Main {
    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        for (int i = 0; i < N; ++i) {
            board[i] = br.readLine().toCharArray();
        }

        // Solve
        boolean[][] mbtiFlags = new boolean[91][4];
        mbtiFlags['E'][0] = mbtiFlags['I'][0] = true;
        mbtiFlags['N'][1] = mbtiFlags['S'][1] = true;
        mbtiFlags['F'][2] = mbtiFlags['T'][2] = true;
        mbtiFlags['P'][3] = mbtiFlags['J'][3] = true;

        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                for (int d = 0; d < 8; ++d) {
                    final int last_i = i + 3 * di[d];
                    final int last_j = j + 3 * dj[d];

                    if (last_i >= 0 && last_i < N && last_j >= 0 && last_j < M) {
                        if (mbtiFlags[board[i][j]][0] &&
                            mbtiFlags[board[i + di[d]][j + dj[d]]][1] &&
                            mbtiFlags[board[i + 2 * di[d]][j + 2 * dj[d]]][2] &&
                            mbtiFlags[board[i + 3 * di[d]][j + 3 * dj[d]]][3]) {
                            ++cnt;
                        }
                    }
                }
            }
        }

        // Output
        System.out.println(cnt);
    }
}