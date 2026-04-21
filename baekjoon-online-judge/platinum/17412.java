import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE / 2;

	static int[][] capacity;
	static int[][] flow;
	static List<Integer>[] graph;
	static int N, P;

	static void addEdge(int u, int v, int cap) {
		capacity[u][v] += cap;
		graph[u].add(v);
		graph[v].add(u);
	}

	static int edmondsKarp(int source, int sink) {
		int totalFlow = 0;

		while (true) {
			int[] prev = new int[N + 1];
			Arrays.fill(prev, -1);

			Deque<Integer> queue = new ArrayDeque<>();
			queue.add(source);
			prev[source] = source;

			while (!queue.isEmpty() && prev[sink] == -1) {
				int cur = queue.poll();

				for (int next : graph[cur]) {
					if (prev[next] == -1 && capacity[cur][next] - flow[cur][next] > 0) {
						prev[next] = cur;
						queue.add(next);
						if (next == sink) break;
					}
				}
			}

			if (prev[sink] == -1) break;

			int amount = INF;
			for (int i = sink; i != source; i = prev[i]) {
				amount = Math.min(amount, capacity[prev[i]][i] - flow[prev[i]][i]);
			}

			for (int i = sink; i != source; i = prev[i]) {
				flow[prev[i]][i] += amount;
				flow[i][prev[i]] -= amount;
			}

			totalFlow += amount;
		}

		return totalFlow;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		capacity = new int[N + 1][N + 1];
		flow = new int[N + 1][N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; ++i) graph[i] = new ArrayList<>();

		for (int i = 0; i < P; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			// Solve
			addEdge(u, v, 1);
		}

		// Output
		System.out.print(edmondsKarp(1, 2));
	}
}