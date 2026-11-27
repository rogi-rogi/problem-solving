import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 1_000_000_000;

	static int N, P, SIZE;
	static int[][] capacity;
	static int[][] flow;
	static List<Integer>[] graph;

	static int in(int x) {
		return x * 2;
	}

	static int out(int x) {
		return x * 2 + 1;
	}

	static void addEdge(int u, int v, int cap) {
		capacity[u][v] += cap;
		graph[u].add(v);
		graph[v].add(u);
	}

	static int edmondsKarp(int source, int sink) {
		int totalFlow = 0;

		while (true) {
			int[] prev = new int[SIZE];
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
		SIZE = 2 * (N + 1) + 2;
		capacity = new int[SIZE][SIZE];
		flow = new int[SIZE][SIZE];
		graph = new ArrayList[SIZE];

		for (int i = 0; i < SIZE; ++i) {
			graph[i] = new ArrayList<>();
		}

		// Solve
		addEdge(in(1), out(1), INF);
		addEdge(in(2), out(2), INF);
		for (int v = 3; v <= N; ++v) {
			addEdge(in(v), out(v), 1);
		}

		for (int i = 0; i < P; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			addEdge(out(u), in(v), INF);
			addEdge(out(v), in(u), INF);
		}

		// Output
		System.out.print(edmondsKarp(out(1), in(2)));
	}
}