import java.io.*;
import java.util.*;

public class Main {
	static int[][] board;
	static int N, M, R;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

	private static boolean isValid(
		int x, int y,
		int start, int ex, int ey
	) {
		return start <= x && x < ex
			&& start <= y && y < ey;
	}

	private static boolean isStart(int x, int y, int start) {
		return start == x && start == y;
	}

	private static void rotate(int start, final int LEN) {
		int r = R % LEN;
		while (r-- > 0) {
			final int temp = board[start][start];
			int x = start, y = start;
			int d = 0;
			while (d < 4) {
				final int nx = x + dx[d];
				final int ny = y + dy[d];
				if (isValid(nx, ny, start, N - start, M - start)) {
					if (isStart(nx, ny, start)) {
						break;
					}
					board[x][y] = board[nx][ny];
					x = nx;
					y = ny;
				} else {
					++d;
				}
			}
			board[start + 1][start] = temp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; ++i) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// Solve
		final int BOX_COUNT = Math.min(N, M) / 2;
		int height = N, width = M;
		for (int i = 0; i < BOX_COUNT; ++i) {
			rotate(i, 2 * height + 2 * width - 4);
			height -= 2;
			width -= 2;
		}

		// Output
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}