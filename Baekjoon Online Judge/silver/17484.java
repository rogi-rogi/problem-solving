import java.io.*;
import java.util.*;


public class Main {
	static int LEFT = 0, MID = 1, RIGHT = 2;
	static int INF = (int)1e9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// Input
		String[] input = br.readLine().split(" ");
		final int N = Integer.parseInt(input[0]);
		final int M = Integer.parseInt(input[1]);
		int[][] board = new int[N][M];
		for (int i = 0; i < N; ++i) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// Solve
		int[][][] dp = new int[N][M][3];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				dp[i][j][LEFT] = dp[i][j][MID] = dp[i][j][RIGHT] = board[i][j];
				if (j == 0) {
					dp[i][0][LEFT] = INF;
				} else if (j == M - 1) {
					dp[i][M - 1][RIGHT] = INF;
				}
			}
		}
		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (j > 0) {
					dp[i][j][LEFT] += Math.min(dp[i - 1][j - 1][MID], dp[i - 1][j - 1][RIGHT]);
				}
				dp[i][j][MID] += Math.min(dp[i - 1][j][LEFT], dp[i - 1][j][RIGHT]);
				if (j < M - 1) {
					dp[i][j][RIGHT] += Math.min(dp[i - 1][j + 1][LEFT], dp[i - 1][j + 1][MID]);
				}
			}
		}

		int res = INF;
		for (int j = 0; j < M; ++j) {
			for (int k = 0; k < 3; ++k) {
				res = Math.min(res, dp[N - 1][j][k]);
			}
		}

		// Output
		System.out.println(res);
	}
}