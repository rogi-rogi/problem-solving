import java.io.*;
import java.util.*;

public class Main {

	static class Query {
		int l, r, idx;

		Query(int l, int r, int idx) {
			this.l = l;
			this.r = r;
			this.idx = idx;
		}
	}

	static int[] A;
	static int[] cnt;
	static int[] freq;
	static int curMax = 0;

	static void add(int x) {
		int c = cnt[x];
		if (c > 0) --freq[c];
		++cnt[x];
		++freq[c + 1];
		if (curMax < c + 1) curMax = c + 1;
	}

	static void remove(int x) {
		int c = cnt[x];
		--freq[c];
		--cnt[x];
		if (c > 1) ++freq[c - 1];
		while (curMax > 0 && freq[curMax] == 0) --curMax;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		Query[] queries = new Query[M];

		for (int idx = 0; idx < M; ++idx) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			queries[idx] = new Query(l, r, idx);
		}

		// Solve
		int block = (int) Math.sqrt(N) + 1;
		Arrays.sort(queries, (q1, q2) -> {
			int blcok1 = q1.l / block, block2 = q2.l / block;
			if (blcok1 != block2) return blcok1 - block2;
			return q1.r - q2.r;
		});

		cnt = new int[(int)1e5 + 1];
		freq = new int[N + 1];
		int[] ans = new int[M];

		int curL = 1, curR = 0;
		for (Query q : queries) {
			while (curL > q.l) add(A[--curL]);
			while (curR < q.r) add(A[++curR]);
			while (curL < q.l) remove(A[curL++]);
			while (curR > q.r) remove(A[curR--]);

			ans[q.idx] = curMax;
		}

		// Output
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; ++i) {
			sb.append(ans[i]).append('\n');
		}
		System.out.print(sb);
	}
}
