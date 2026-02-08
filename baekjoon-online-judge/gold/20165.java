import java.io.*;
import java.util.*;

public class Main {
	static int[][] board;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0}; // E, W, S, N
	static int N, M;

	private static boolean isValid(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	private static int attack(int startX, int startY, String D) {
		if (board[startX][startY] < 0) {
			return 0;
		}

		final int d = switch(D) {
			case "E" -> 0;
			case "W" -> 1;
			case "S" -> 2;
			default -> 3; // "N"
		};

		int cnt = 0;
		int reach = 1;

		for (int i = 0; i < reach; i++) {
			int currentX = startX + dx[d] * i;
			int currentY = startY + dy[d] * i;

			if (!isValid(currentX, currentY)) {
				break;
			}

			if (board[currentX][currentY] > 0) {
				reach = Math.max(reach, i + board[currentX][currentY]);
				board[currentX][currentY] *= -1;
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// Input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		for (int i = 0; i < N; ++i) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// Solve
		int cnt = 0;
		while (R-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			String d = st.nextToken();
			cnt += attack(x, y, d);

			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			board[x][y] = Math.abs(board[x][y]);
		}

		// Output
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append('\n');
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				sb.append(board[i][j] > 0 ? "S " : "F ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}