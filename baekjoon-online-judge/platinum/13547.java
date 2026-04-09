import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] arr;
	static int[] cnt;
	static int[] ans;
	static int currentAnswer = 0;

	static class Query {
		int l, r, idx, block;

		Query(int l, int r, int idx, int block) {
			this.l = l;
			this.r = r;
			this.idx = idx;
			this.block = block;
		}
	}

	static void add(int value) {
		if (cnt[value] == 0) ++currentAnswer;
		++cnt[value];
	}

	static void remove(int value) {
		--cnt[value];
		if (cnt[value] == 0) --currentAnswer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		cnt = new int[1_000_001];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int blockSize = (int) Math.sqrt(N);

		M = Integer.parseInt(br.readLine());
		Query[] queries = new Query[M];
		ans = new int[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			// Solve
			queries[i] = new Query(l, r, i, (l - 1) / blockSize);
		}

		Arrays.sort(queries, (a, b) -> {
			if (a.block != b.block) {
				return Integer.compare(a.block, b.block);
			}
			return Integer.compare(a.r, b.r);
		});

		int curL = 1;
		int curR = 0;

		for (Query q : queries) {
			int L = q.l;
			int R = q.r;

			while (curL > L) add(arr[--curL]);
			while (curR < R) add(arr[++curR]);
			while (curL < L) remove(arr[curL++]);
			while (curR > R) remove(arr[curR--]);

			ans[q.idx] = currentAnswer;
		}

		// Output
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(ans[i]).append('\n');
		}
		System.out.print(sb);
	}
}