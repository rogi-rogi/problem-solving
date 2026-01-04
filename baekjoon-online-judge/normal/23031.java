import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static int UP = 0, LEFT = 1, DOWN = 2, RIGHT = 3;
	static char SWITCH = 'S', ZOMBIE = 'Z';
	static int[] dx = new int[]{-1, 0, 1, 0},
		dy = new int[]{0, -1, 0, 1};

	static char[][] board;
	static boolean[][] light;

	static class User {
		int x, y;
		int dir = DOWN;
		User(int x, int y) {
			this.x = x;
			this.y = y;
		}
		void reverse() {
			this.dir = (this.dir + 2) % 4;
		}
	}

	private static boolean isValid(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	private static boolean faint(int x, int y, User user) {
		return x == user.x && y == user.y
			&& !light[x][y]
			&& board[x][y] != SWITCH;
	}

	private static boolean solve(char[] A) {
		// find Zombie
		List<User> zombies = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (board[i][j] == ZOMBIE) {
					zombies.add(new User(i, j));
				}
			}
		}
		if (zombies.isEmpty()) {
			return true;
		}


		Deque<Character> actions = new ArrayDeque<>();
		for (char c : A) {
			actions.add(c);
		}

		User user = new User(0, 0);
		while (!actions.isEmpty()) {
			/*
			아리 먼저 움직인다.
			 */
			switch (actions.poll()) {
				case 'F':
					int nx = user.x + dx[user.dir];
					int ny = user.y + dy[user.dir];
					if (isValid(nx, ny)) {
						user.x = nx;
						user.y = ny;
						if (board[nx][ny] == SWITCH) {
							for (int i = -1; i <= 1; ++i) {
								for (int j = -1; j <= 1; ++j) {
									if (isValid(nx + i, ny + j)) {
										light[nx + i][ny + j] = true;
									}
								}
							}
						}
					}
					break;
				case 'L':
					user.dir = (user.dir + 1) % 4;
					break;
				case 'R':
					user.dir = (user.dir + 3) % 4;
					break;
			}
			/*
			학생 좀비들이 움직인다.
			 */
			for (User zombie : zombies) {
				if (faint(zombie.x, zombie.y, user)) return false;

				int nx = zombie.x + dx[zombie.dir];
				int ny = zombie.y + dy[zombie.dir];

				if (isValid(nx, ny)) {
					if (faint(nx, ny, user)) return false;
					zombie.x = nx;
					zombie.y = ny;
				} else {
					zombie.reverse();
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		N = Integer.parseInt(br.readLine());
		char[] A = br.readLine().toCharArray();
		board = new char[N][N];
		light = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();
		}

		// Solve & Output
		System.out.println(!solve(A) ? "Aaaaaah!" : "Phew...");
	}
}