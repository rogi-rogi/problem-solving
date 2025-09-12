import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] board;
	static int flag;

	private static boolean isValid(int x, int y) {
		return 0 <= x && x < 5 && 0 <= y && y < 5;
	}
	private static void dfs(int x, int y, int cnt, int depth) {

		if (!isValid(x, y) || board[x][y] == -1 || depth > 3) {
			return;
		}

		if (board[x][y] == 1) {
			++cnt;
			if (cnt == 2) {
				flag = 1;
				return;
			}
		}

		final int temp = board[x][y];
		board[x][y] = -1;
		for (int d = 0; d < 4; ++d) {
			dfs(x + dx[d], y + dy[d], cnt, depth + 1);
		}
		board[x][y] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		board = new int[5][5];
		for (int i = 0; i < 5; ++i) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		String[] input = br.readLine().split(" ");
		final int R = Integer.parseInt(input[0]);
		final int C = Integer.parseInt(input[1]);

		// Solve
		dfs(R, C, 0, 0);

		// Output
		System.out.println(flag);
	}
}