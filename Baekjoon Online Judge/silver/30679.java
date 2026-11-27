import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int N, M;
    static int[][] board;

    private static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    private static boolean dfs(int x, int y, int d, boolean[][][] visited) {
        if (isValid(x, y)) {
            if (!visited[x][y][d]) {
                visited[x][y][d] = true;
                return dfs(x + board[x][y] * dx[d], y + board[x][y] * dy[d], (d + 1) % 4, visited);
            } else {
                return true;
            }
        }
        return false;
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

        // Solve
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            boolean[][][] visited = new boolean[N][M][4];
            if (dfs(i, 0, 0, visited)) {
                rows.add(i + 1);
            }
        }

        // Output
        StringBuilder sb = new StringBuilder();
        sb.append(rows.size()).append("\n");
        rows.sort(null);
        for (Integer row : rows) {
            sb.append(row).append(" ");
        }
        System.out.println(sb);
    }
}