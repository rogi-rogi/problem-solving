import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE / 2;

	static int[][] capacity;
	static int[][] flow;
	static List<Integer>[] graph;
	static int V, S, T;

	static void addEdge(int u, int v, int cap) {
		capacity[u][v] += cap;
		graph[u].add(v);
		graph[v].add(u);
	}

	static int edmondsKarp() {
		int totalFlow = 0;

		while (true) {
			int[] prev = new int[V];
			Arrays.fill(prev, -1);

			Deque<Integer> queue = new ArrayDeque<>();
			queue.add(S);
			prev[S] = S;

			while (!queue.isEmpty() && prev[T] == -1) {
				int cur = queue.poll();

				for (int next : graph[cur]) {
					if (prev[next] == -1 && capacity[cur][next] - flow[cur][next] > 0) {
						prev[next] = cur;
						queue.add(next);
						if (next == T) break;
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
			}

			totalFlow += amount;
		}

		return totalFlow;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		S = 0;
		int personStart = 1, storeStart = N + 1;
		T = N + M + 1;
		V = T + 1;
		capacity = new int[V][V];
		flow = new int[V][V];
		graph = new ArrayList[V];
		for (int i = 0; i < V; ++i) graph[i] = new ArrayList<>();

		int[] A = new int[N + 1];
		int[] B = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; ++i) B[i] = Integer.parseInt(st.nextToken());

		// Solve
		for (int i = 1; i <= M; ++i) addEdge(S, storeStart + i - 1, B[i]);
		for (int i = 1; i <= N; ++i) addEdge(personStart + i - 1, T, A[i]);
		for (int i = 1;i <= M; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; ++j) {
				int c = Integer.parseInt(st.nextToken());
				addEdge(storeStart + i - 1, personStart + j - 1, c);
			}
		}

		// Output
		System.out.print(edmondsKarp());
	}
}