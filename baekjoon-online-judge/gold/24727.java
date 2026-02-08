import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] board;

	private static boolean solve(int C, int E) {
		if (N * N <= C + E) {
			return false;
		}
		fillA(C);
		return fillB(E);
	}

	private static void fillA(int cnt) {
		for (int i = 0; i < 2*N; ++i) {
			for (int j = 0; j <= i; ++j) {
				int r = i - j;
				if (r >= N || j >= N) {
					continue;
				}
				board[r][j] = 1;
				if (--cnt == 0) {
					return;
				}
			}
		}
	}

	private static boolean fillB(int cnt) {
		for (int i = N - 1; i >= -N; --i) {
			for (int j = N - 1; j >= i; --j) {
				int r = i + (N - j - 1);
				if (r < 0 || j < 0) {
					continue;
				}
				if (board[r][j] == 1 ||
					(j > 0 && board[r][j - 1] == 1) ||
					(r > 0 && board[r - 1][j] == 1)) {
					return false;
				}

				board[r][j] = 2;
				if (--cnt == 0) return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		N = Integer.parseInt(br.readLine());
		String[] in = br.readLine().split(" ");
		int C = Integer.parseInt(in[0]);
		int E = Integer.parseInt(in[1]);

		board = new int[N][N];

		// Solve
		if (solve(C, E)) {
			// Output
			sb.append(1).append('\n');
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) sb.append(board[i][j]);
				sb.append('\n');
			}
		} else sb.append(-1).append('\n');
		System.out.print(sb);
	}
}