import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE / 2;

	static int[][] capacity;
	static int[][] flow;
	static int[][] cost;
	static List<Integer>[] graph;

	static int V, S, T;

	static void addEdge(int u, int v, int cap, int c) {
		graph[u].add(v);
		graph[v].add(u);

		capacity[u][v] += cap;
		cost[u][v] = c;
		cost[v][u] = -c;
	}

	static int mcmf() {
		int totalCost = 0;

		while (true) {
			int[] prev = new int[V];
			int[] dist = new int[V];
			boolean[] inQueue = new boolean[V];

			Arrays.fill(prev, -1);
			Arrays.fill(dist, INF);

			Deque<Integer> queue = new ArrayDeque<>();
			queue.add(S);
			dist[S] = 0;
			prev[S] = S;
			inQueue[S] = true;

			while (!queue.isEmpty()) {
				int cur = queue.poll();
				inQueue[cur] = false;

				for (int next : graph[cur]) {
					if (capacity[cur][next] - flow[cur][next] <= 0) continue;

					if (dist[next] > dist[cur] + cost[cur][next]) {
						dist[next] = dist[cur] + cost[cur][next];
						prev[next] = cur;

						if (!inQueue[next]) {
							queue.add(next);
							inQueue[next] = true;
						}
					}
				}
			}

			if (prev[T] == -1) break;

			int amount = INF;
			for (int i = T; i != S; i = prev[i]) {
				amount = Math.min(amount, capacity[prev[i]][i] - flow[prev[i]][i]);
			}

			for (int i = T; i != S; i = prev[i]) {
				flow[prev[i]][i] += amount;
				flow[i][prev[i]] -= amount;
				totalCost += amount * cost[prev[i]][i];
			}
		}

		return totalCost;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		S = 0;
		T = N + M + 1;
		V = T + 1;

		capacity = new int[V][V];
		flow = new int[V][V];
		cost = new int[V][V];
		graph = new ArrayList[V];

		for (int i = 0; i < V; ++i) {
			graph[i] = new ArrayList<>();
		}
		int[] A = new int[N + 1];
		int[] B = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; ++i) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		// Solve
		int personStart = 1, storeStart = N + 1;
		for (int i = 1; i <= M; ++i) {
			addEdge(S, storeStart + i - 1, B[i], 0);
		}

		for (int i = 1; i <= M; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; ++j) {
				int c = Integer.parseInt(st.nextToken());
				addEdge(storeStart + i - 1, personStart + j - 1, INF, c);
			}
		}

		for (int i = 1; i <= N; ++i) {
			addEdge(personStart + i - 1, T, A[i], 0);
		}

		// Output
		System.out.print(mcmf());
	}
}