import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[][] board = new int[2][];
        board[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        board[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve & Output
        System.out.println(getEdgeCnt(N, board));
    }

    private static int getEdgeCnt(int N, int[][] board) {
        int res = 0;
        for (int i = 0; i < N; ++i) {
            int midOverlaps = (board[0][i] == 1 && board[1][i] == 1 && i % 2 == 0) ? 1 : 0;
            if (board[0][i] == 1) {
                res += 3 - midOverlaps
                        - (i - 1 >= 0 && board[0][i - 1] == 1 ? 1 : 0) // 왼쪽 삼각형 확인
                        - (i + 1 < N && board[0][i + 1] == 1 ? 1 : 0); // 오른쪽 삼각형 확인
            }
            if (board[1][i] == 1) {
                res += 3 - midOverlaps
                        - (i - 1 >= 0 && board[1][i - 1] == 1 ? 1 : 0)
                        - (i + 1 < N && board[1][i + 1] == 1 ? 1 : 0);
            }
        }
        return res;
    }
}
