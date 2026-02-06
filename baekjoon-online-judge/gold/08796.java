import java.io.*;
import java.util.*;

public class Main {
	static int[][] graph;

	static String bfs(int N, int K) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, -1);

		Deque<Integer> q = new ArrayDeque<>();
		dist[1] = 0;
		q.add(1);

		int[] cnt = new int[N + 1];

		while (!q.isEmpty()) {
			int u = q.poll();
			int du = dist[u];

			for (int v : graph[u]) {
				if (dist[v] != -1) continue;
				dist[v] = du + 1;
				q.add(v);

				int d = dist[v];
				if (++cnt[d] > K) return String.valueOf(d);
			}
		}
		return "hurray!";
	}

	public static void main(String[] args) throws Exception {
		FastScanner fs = new FastScanner(System.in);
		StringBuilder sb = new StringBuilder();

		// Input
		int Z = fs.nextInt();
		while (Z-- > 0) {
			int N = fs.nextInt();
			int M = fs.nextInt();
			int K = fs.nextInt();

			int[] U = new int[M];
			int[] V = new int[M];
			int[] cnt = new int[N + 1];

			// Solve
			for (int i = 0; i < M; i++) {
				int u = fs.nextInt(), v = fs.nextInt();
				U[i] = u; V[i] = v;
				++cnt[u]; ++cnt[v];
			}

			graph = new int[N + 1][];
			for (int i = 1; i <= N; ++i) graph[i] = new int[cnt[i]];

			int[] idx = new int[N + 1];
			for (int i = 0; i < M; i++) {
				int u = U[i], v = V[i];
				graph[u][idx[u]++] = v;
				graph[v][idx[v]++] = u;
			}
			sb.append(bfs(N, K)).append('\n');
		}

		// Output
		System.out.print(sb);
	}

	static final class FastScanner {
		private final InputStream in;
		private final byte[] buffer = new byte[1 << 16];
		private int ptr = 0, len = 0;

		FastScanner(InputStream in) { this.in = in; }

		private int readByte() throws IOException {
			if (ptr >= len) {
				len = in.read(buffer);
				ptr = 0;
				if (len <= 0) return -1;
			}
			return buffer[ptr++];
		}

		int nextInt() throws IOException {
			int c;
			do { c = readByte(); } while (c <= ' ' && c != -1);

			int sign = 1;
			if (c == '-') { sign = -1; c = readByte(); }

			int val = 0;
			while (c > ' ') {
				val = val * 10 + (c - '0');
				c = readByte();
			}
			return val * sign;
		}
	}
}
