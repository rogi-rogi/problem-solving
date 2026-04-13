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

	static int[] mcmf() {
		int totalFlow = 0, totalCost = 0;

		while (true) {
			int[] prev = new int[V];
			int[] dist = new int[V];
			boolean[] inQueue = new boolean[V];

			Arrays.fill(prev, -1);
			Arrays.fill(dist, INF);

			Deque<Integer> q = new ArrayDeque<>();
			q.add(S);
			dist[S] = 0;
			prev[S] = S;
			inQueue[S] = true;

			while (!q.isEmpty()) {
				int cur = q.poll();
				inQueue[cur] = false;

				for (int next : graph[cur]) {
					if (capacity[cur][next] - flow[cur][next] <= 0) continue;

					if (dist[next] > dist[cur] + cost[cur][next]) {
						dist[next] = dist[cur] + cost[cur][next];
						prev[next] = cur;

						if (!inQueue[next]) {
							q.add(next);
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

			totalFlow += amount;
			if (totalFlow == 2) break;
		}

		return new int[]{totalFlow, totalCost};
	}

	static int in(int x) {
		return x;
	}

	static int out(int x, int v) {
		return x + v;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		String line;
		StringTokenizer st;
		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line);
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			V = 2 * v + 1;
			capacity = new int[V][V];
			flow = new int[V][V];
			cost = new int[V][V];
			graph = new ArrayList[V];
			for (int i = 0; i < V; ++i) graph[i] = new ArrayList<>();

			// Solve
			addEdge(in(1), out(1, v), 2, 0);
			for (int i = 2; i < v; ++i) {
				addEdge(in(i), out(i, v), 1, 0);
			}
			for (int i = 0; i < e; ++i) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				addEdge(out(a, v), in(b), 1, c);
			}

			S = out(1, v);
			T = in(v);

			int[] result = mcmf();
			sb.append(result[1]).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}