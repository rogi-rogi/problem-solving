import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int EMPTY = 0;
	static int[][] board;
	static int[] dx = {-1, 0, 0, 1},
		dy = {0, -1, 1, 0};

	static class Shark {
		int x, y;
		int size = 2, eaten = 0, time = 0;
		Shark(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public void eat(Fish fish, int[][] board) {
			this.time += fish.dist;
			this.x = fish.x;
			this.y = fish.y;
			board[this.x][this.y] = EMPTY;

			this.eaten++;
			if (this.eaten == this.size) {
				this.eaten = EMPTY;
				++this.size;
			}
		}
	}

	static class Fish {
		int x, y, dist;
		Fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		void update(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	private static boolean isValid(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	private static Fish bfs(Shark shark) {
		boolean[][] visited = new boolean[N][N];
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{shark.x, shark.y, 0});
		visited[shark.x][shark.y] = true;

		Fish result = new Fish(shark.x, shark.y, Integer.MAX_VALUE);
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0], y = cur[1], dist = cur[2];

			if (dist > result.dist) break;
			int fishSize = board[x][y];
			if (fishSize > 0 && fishSize < shark.size) {
				if (dist < result.dist ||
					(dist == result.dist
						&& (x < result.x || (x == result.x && y < result.y))
					)
				) {
					result.update(x, y, dist);
				}
				continue;
			}
			for (int d = 0; d < 4; ++d) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (isValid(nx, ny) && !visited[nx][ny]) {
					if (board[nx][ny] > shark.size) continue;
					visited[nx][ny] = true;
					queue.add(new int[]{nx, ny,  dist + 1});
				}
			}
		}
		if (result.dist == Integer.MAX_VALUE) {
			return new Fish(-1, -1, -1);
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		N = Integer.parseInt(br.readLine());
		Shark shark = null;
		board = new int[N][N];
		for (int i = 0; i < N; ++i) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < N; ++j) {
				if (board[i][j] == 9) { // is shark
					shark = new Shark(i, j);
					board[i][j] = EMPTY;
				}
			}
		}

		// Solve
		while (true) {
			Fish fish = bfs(shark);
			if (fish.dist == -1) break;
			shark.eat(fish, board);
		}

		// Output
		System.out.println(shark.time);
	}
}