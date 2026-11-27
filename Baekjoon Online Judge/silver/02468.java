import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static int bfs(int x, int y, int water) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{x, y});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];

			for (int d = 0; d < 4; ++d) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (!visited[nx][ny] && graph[nx][ny] > water) {
						visited[nx][ny] = true;
						queue.add(new int[]{nx, ny});
					}
				}
			}
		}
		return 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];

		Set<Integer> waterHeights = new HashSet<>();

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				waterHeights.add(graph[i][j]);
			}
		}

		// Solve
		int result = 1;
		for (int h : waterHeights) {
			visited = new boolean[N][N];
			int count = 0;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (!visited[i][j] && graph[i][j] > h) {
						count += bfs(i, j, h);
					}
				}
			}
			result = Math.max(result, count);
		}

		// Output
		System.out.print(result);
	}
}