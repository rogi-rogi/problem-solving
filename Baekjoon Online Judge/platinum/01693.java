import java.io.*;
import java.util.*;

public class Main {
	static final int MAX_COLOR = 20;
	static List<Integer>[] graph, tree;
	static long[][] dp;
	static int[] order;
	static int lastNodeOrder = 0;

	static void buildTree(int N) {
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;

		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		order = new int[N];

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			order[lastNodeOrder++] = cur;
			for (int next : graph[cur]) {
				if (visited[next]) continue;
				visited[next] = true;
				tree[cur].add(next);
				queue.add(next);
			}
		}
	}

	static void solve(int N) {
		dp = new long[N + 1][MAX_COLOR + 1];
		for (int i = N - 1; i >= 0; --i) {
			int cur = order[i];

			for (int color = 1; color <= MAX_COLOR; ++color) {
				dp[cur][color] = color;

				// cur is parent node
				for (int child : tree[cur]) {
					long min = Long.MAX_VALUE;

					for (int childColor = 1; childColor <= MAX_COLOR; ++childColor) {
						if (childColor == color) continue;
						min = Math.min(min, dp[child][childColor]);
					}

					dp[cur][color] += min;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// Input
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; ++i) {
			graph[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		// Solve
		buildTree(N);
		solve(N);

		long answer = Long.MAX_VALUE;
		for (int color = 1; color <= MAX_COLOR; ++color) {
			answer = Math.min(answer, dp[1][color]);
		}

		// Output
		System.out.print(answer);
	}
}
