import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] visited, parents;

	private static void dfs(int cur, int depth) {
		visited[cur] = depth;
		for (int next = 1; next <= N; ++next) {
			if (visited[next] == 0 && parents[next] == cur) {
				dfs(next, depth + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		N = Integer.parseInt(br.readLine());
		parents = new int[N + 1];
		visited = new int[N + 1];
		parents[0] = 0;
		int root = -1;
		for (int i = 1; i <= N; ++i) {
			parents[i] = Integer.parseInt(br.readLine());
			if (parents[i] == -1) {
				root = i;
			}
		}

		// Solve
		dfs(root, 0);

		// Output
		for (int i = 1; i <= N; ++i) {
			sb.append(visited[i]).append('\n');
		}
		System.out.println(sb);
	}
}
