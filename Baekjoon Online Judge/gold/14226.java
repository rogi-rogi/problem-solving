import java.io.*;
import java.util.*;

public class Main {

	static int solve(int S) {
		if (S == 1) return 0;

		int MAX = 2*S;
		boolean[][] visited = new boolean[MAX + 1][MAX + 1]; // {buf, out}

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{0, 0, 1}); // {cnt, buf, out}
		visited[0][1] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cnt = cur[0];
			int buf = cur[1];
			int out = cur[2];

			if (out == S) {
				return cnt;
			}

			if (!visited[out][out]) {
				visited[out][out] = true;
				queue.add(new int[]{cnt + 1, out, out});
			}

			if (buf > 0 && out + buf <= MAX && !visited[buf][out + buf]) {
				visited[buf][out + buf] = true;
				queue.add(new int[]{cnt + 1, buf, out + buf});
			}

			if (out > 1 && !visited[buf][out - 1]) {
				visited[buf][out - 1] = true;
				queue.add(new int[]{cnt + 1, buf, out - 1});
			}
		}
		return MAX;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int S = Integer.parseInt(br.readLine());

		// Solve & Output
		System.out.print(solve(S));
	}
}