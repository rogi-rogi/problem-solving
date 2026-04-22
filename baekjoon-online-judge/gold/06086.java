import java.io.*;
import java.util.*;

public class Main {
	static final int SIZE = 52;
	static int[][] capacity = new int[SIZE][SIZE];
	static int[][] flow = new int[SIZE][SIZE];
	static List<Integer>[] graph = new ArrayList[SIZE];

	static int charToIndex(char c) {
		if ('A' <= c && c <= 'Z') return c - 'A';
		return c - 'a' + 26;
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

			int amount = Integer.MAX_VALUE;
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
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < SIZE; ++i) {
			graph[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			int u = charToIndex(st.nextToken().charAt(0));
			int v = charToIndex(st.nextToken().charAt(0));
			int c = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);

			// Solve
			capacity[u][v] += c;
			capacity[v][u] += c;
		}

		// Output
		System.out.print(edmondsKarp(charToIndex('A'), charToIndex('Z')));
	}
}