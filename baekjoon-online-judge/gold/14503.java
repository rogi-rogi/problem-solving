import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static int r, c, d;

	// 0: 북, 1: 동, 2: 남, 3: 서
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	static int[][] board;
	static final int CLEAN = -1, BLOCK = 1, EMPTY = 0;

	private static int simulation() {
		int cleanCnt = 0;

		while (true) {
			if (board[r][c] == EMPTY) {
				board[r][c] = CLEAN;
				++cleanCnt;
			}

			boolean moved = false;
			for (int i = 0; i < 4; ++i) {
				d = (d + 3) % 4;
				int nx = r + dx[d];
				int ny = c + dy[d];

				if (board[nx][ny] == EMPTY) {
					r = nx;
					c = ny;
					moved = true;
					break;
				}
			}

			if (moved) continue;
			int backX = r - dx[d];
			int backY = c - dy[d];

			if (board[backX][backY] == BLOCK) break;
			r = backX;
			c = backY;
		}

		return cleanCnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// Solve & Output
		System.out.print(simulation());
	}
}