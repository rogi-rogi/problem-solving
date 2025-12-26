import java.io.*;
import java.util.*;

public class Main {
	static final char EMPTY = 'x', MINE = '*';
	static int N;
	static char[][] mineMap, userMap;
	static int[] dx = new int[]{-1, -1, -1, 0, 1, 1,  1,  0};
	static int[] dy = new int[]{-1,  0,  1, 1, 1, 0, -1, -1};

	private static boolean isValid(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	private static void solve() {
		boolean flag = false;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (userMap[i][j] == EMPTY) {
					if (mineMap[i][j] == MINE) {
						flag = true;
						userMap[i][j] = MINE;
						continue;
					}
					int cnt = 0;
					for (int d = 0; d < 8; ++d) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (isValid(nx, ny) && mineMap[nx][ny] == MINE) {
							++cnt;
						}
					}
					userMap[i][j] = (char)('0' + cnt);
				}
			}
		}
		if (flag) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (mineMap[i][j] == MINE) {
						userMap[i][j] = MINE;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		N = Integer.parseInt(br.readLine());
		mineMap = new char[N][N];
		userMap = new char[N][N];

		for(int i = 0; i < N; ++i) {
			mineMap[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; ++i) {
			userMap[i] = br.readLine().toCharArray();
		}

		// Solve
		solve();

		// Output
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			sb.append(userMap[i]).append('\n');
		}
		System.out.println(sb);
	}
}