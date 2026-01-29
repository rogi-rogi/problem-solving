import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int Q = Integer.parseInt(in[1]);
        int[][] board = new int[5][N + 1];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            in = br.readLine().split(" ");
            if (in[0].equals("1")) {
                int a = Integer.parseInt(in[1]);
                int b = Integer.parseInt(in[2]);
                ++board[a][b];
                for (int d = 0; d < 4; ++d) {
                    int nx = a + dx[d];
                    int ny = b + dy[d];
                    if (1 <= nx && nx <= 4 && 1 <= ny && ny <= N) {
                        ++board[nx][ny];
                    }
                }
            } else if (in[0].equals("2")) {
                int a = Integer.parseInt(in[1]);
                int idx = 0, max = 0;
                for (int i = 1; i <= N; ++i) {
                    if (board[a][i] > max) {
                        max = board[a][i];
                        idx = i;
                    }
                }
                sb.append(idx == 0 ? 1 : idx).append('\n');
            }
        }

        int max = 0;
        int x = 1, y = 1;
        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (board[i][j] > max) {
                    max = board[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        sb.append(x).append(' ').append(y);

        // Output
        System.out.println(sb);
    }
}