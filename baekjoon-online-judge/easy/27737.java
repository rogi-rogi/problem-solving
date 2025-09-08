import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] board;

	private static boolean isValid(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	private static int bfs(int x, int y) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x, y});
		board[x][y] = 1;
		int cnt = 1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			x = cur[0];
			y = cur[1];
			for (int d = 0; d < 4; ++d) {
				final int nx = x + dx[d];
				final int ny = y + dy[d];
				if (isValid(nx, ny) && board[nx][ny] == 0) {
					queue.add(new int[]{nx, ny});
					board[nx][ny] = 1;
					++cnt;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		final int M = Integer.parseInt(input[1]);
		final int K = Integer.parseInt(input[2]);

		board = new int[N][N];
		for (int i = 0; i < N; ++i) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// Solve
		int m = M;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (board[i][j] == 0) {
					m -= (bfs(i, j) + (K - 1)) / K;
				}
			}
		}

		// Output
		if (m < 0 || m == M) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println("POSSIBLE");
			System.out.println(m);
		}
	}
}