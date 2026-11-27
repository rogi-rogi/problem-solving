import java.io.*;
import java.util.*;

public class Main {

	static int N, T;
	static int[] arr;
	static int[] cnt;
	static long[] ans;
	static long currentAnswer = 0;

	static class Query implements Comparable<Query> {
		int l, r, idx, block;

		Query(int l, int r, int idx, int block) {
			this.l = l;
			this.r = r;
			this.idx = idx;
			this.block = block;
		}

		@Override
		public int compareTo(Query o) {
			if (this.block != o.block) {
				return Integer.compare(this.block, o.block);
			}
			return Integer.compare(this.r, o.r);
		}
	}

	static void add(int value) {
		currentAnswer += (2L * cnt[value] + 1L) * value;
		++cnt[value];
	}

	static void remove(int value) {
		currentAnswer -= (2L * cnt[value] - 1L) * value;
		--cnt[value];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		cnt = new int[1_000_001];
		ans = new long[T];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int blockSize = (int) Math.sqrt(N);
		Query[] queries = new Query[T];

		for (int i = 0; i < T; ++i) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			// Solve
			queries[i] = new Query(l, r, i, l / blockSize);
		}

		Arrays.sort(queries);

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
		for (int i = 0; i < T; ++i) {
			sb.append(ans[i]).append('\n');
		}
		System.out.print(sb);
	}
}