import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N + 1][N + 1];
		for (int i = 1; i <= N; ++i) {
			int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 1; j <= N; ++j) {
				board[i][j] = line[j - 1];
			}
		}

		// Solve
		int INF = (int) 1e9;
		int[][] dp = new int[N + 1][N + 1];
		for (int i = 0; i <= N; ++i) {
			Arrays.fill(dp[i], INF);
		}

		dp[1][1] = 0;
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				if (i == 1 && j == 1) continue;
				dp[i][j] = Math.min(
					dp[i - 1][j] + Math.max(0, board[i][j] - board[i - 1][j] + 1),
					dp[i][j - 1] + Math.max(0, board[i][j] - board[i][j - 1] + 1)
				);
			}
		}

		// Output
		System.out.println(dp[N][N]);
	}
}
