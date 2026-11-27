import java.io.*;
import java.util.*;

public class Main {
    final static int EMPTY = 0, FILL = 1, BLOCK = 2;
    static int[][] board;
    static int[][] D = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N, M;
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = input[0];
        N = input[1];
        int K = input[2];
        board = new int[N][M];

        while (K-- > 0) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = input[0]; i < input[2]; ++i) {
                for (int j = input[1]; j < input[3]; ++j) {
                    board[i][j] = BLOCK;
                }
            }
        }
        
        // Solve
        int cnt = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i][j] == EMPTY) {
                    res.add(bfs(i, j));
                    ++cnt;
                }
            }
        }
        Collections.sort(res);

        // Output
        System.out.println(cnt);
        System.out.println(res.toString().replaceAll("[\\[\\],]", ""));
    }
    private static int bfs(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>(List.of(new int[]{x, y}));
        board[x][y] = FILL;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.pop();
            for (int[] d : D) {
                final int nx = cur[0] + d[0];
                final int ny = cur[1] + d[1];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny] == EMPTY) {
                    board[nx][ny] = FILL;
                    queue.add(new int[]{nx, ny});
                    ++cnt;
                }
            }
        }
        return cnt;
    }
}
