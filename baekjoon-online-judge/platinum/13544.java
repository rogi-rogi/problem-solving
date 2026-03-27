import java.io.*;
import java.util.*;

public class Main {
	static int[][] tree;
	static int[] leaf;

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
			return tree[node].length - upperBound(tree[node], qk);
		}

		final int mid = (left + right) >> 1;
		final int child = node << 1;
		return query(qi, qj, qk, left, mid, child)
			+ query(qi, qj, qk, mid + 1, right, child + 1);
	}

	private static int upperBound(int[] arr, int target) {
		int left = 0, right = arr.length;

		while (left < right) {
			int mid = (left + right) >> 1;
			if (arr[mid] <= target) left = mid + 1;
			else right = mid;
		}
		return left;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		leaf = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			leaf[i] = Integer.parseInt(st.nextToken());
		}

		// Solve
		tree = new int[4 * N][];
		build(1, N, 1);

		int Q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int prev = 0;
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) ^ prev;
			int j = Integer.parseInt(st.nextToken()) ^ prev;
			int k = Integer.parseInt(st.nextToken()) ^ prev;
			sb.append(prev = query(i, j, k, 1, N, 1)).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}