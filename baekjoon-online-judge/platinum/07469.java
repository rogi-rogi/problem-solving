import java.io.*;
import java.util.*;

public class Main {
	static int[][] tree;
	static int[] leaf;
	static int[] values;

	private static void build(int left, int right, int node) {
		if (left == right) {
			tree[node] = new int[]{leaf[left]};
			return;
		}

		final int mid = (left + right) >> 1;
		final int child = node << 1;
		build(left, mid, child);
		build(mid + 1, right, child + 1);
		tree[node] = merge(tree[child], tree[child + 1]);
	}

	private static int[] merge(int[] a, int[] b) {
		int[] merged = new int[a.length + b.length];
		int i = 0, j = 0, idx = 0;

		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				merged[idx++] = a[i++];
			} else {
				merged[idx++] = b[j++];
			}
		}
		while (i < a.length) merged[idx++] = a[i++];
		while (j < b.length) merged[idx++] = b[j++];
		return merged;
	}

	private static int query(int qi, int qj, int qk, int left, int right, int node) {
		if (right < qi || qj < left) return 0;
		if (qi <= left && right <= qj) {
			return upperBound(tree[node], qk);
		}

		final int mid = (left + right) >> 1;
		final int child = node << 1;
		return query(qi, qj, qk, left, mid, child)
			+ query(qi, qj, qk, mid + 1, right, child + 1);
	}

	private static int upperBound(int[] arr, int target) {
		int left = 0, right = arr.length;

		while (left < right) {
			final int mid = (left + right) >> 1;
			if (arr[mid] <= target) left = mid + 1;
			else right = mid;
		}
		return left;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		leaf = new int[N + 1];
		values = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			leaf[i] = Integer.parseInt(st.nextToken());
			values[i - 1] = leaf[i];
		}

		// Solve
		Arrays.sort(values);

		tree = new int[4 * N][];
		build(1, N, 1);

		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int left = 0;
			int right = N - 1;
			int answer = values[0];

			while (left <= right) {
				final int mid = (left + right) >> 1;
				final int count = query(i, j, values[mid], 1, N, 1);

				if (count >= k) {
					answer = values[mid];
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

			sb.append(answer).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}