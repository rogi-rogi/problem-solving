import java.io.*;

public class Main {
    final static int MAX = 15;
    final static boolean[] visited = new boolean[10];
    static int res = 987_654_321;

    private static boolean isMagicSquare(int[][] board) {
        int sumDiagonal = board[0][0] + board[1][1] + board[2][2];
        int sumAndiDiagonal = board[0][2] + board[1][1] + board[2][0];
        if (sumDiagonal != MAX || sumAndiDiagonal != MAX) return false;
        for (int row = 0; row < 3; ++row) {
            if (board[row][0] + board[row][1] + board[row][2] != MAX) return false;
        }
        for (int col = 0; col < 3; ++col) {
            if (board[0][col] + board[1][col] + board[2][col] != MAX) return false;
        }
        return true;
    }

    private static void dfs(int[][] board, int depth, int cost) {
        if (depth == 9 && isMagicSquare(board)) {
            res = Math.min(res, cost);
            return;
        }
        int x = depth / 3;
        int y = depth % 3;
        for (int num = 1, temp; num <= 9; ++num) {
            if (!visited[num]) {
                visited[num] = true;
                temp = board[x][y];
                board[x][y] = num;
                dfs(board, depth + 1, cost + Math.abs(temp - num));
                board[x][y] = temp;
                visited[num] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[][] board = new int[3][3];
        for (int i = 0; i < 3; ++i) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 3; ++j) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        // Solve
        dfs(board, 0, 0);

        // Output
        System.out.println(res);
    }
}
