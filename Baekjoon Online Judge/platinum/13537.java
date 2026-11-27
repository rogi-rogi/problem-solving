import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] tree;
	static int[] leaf;

	private static void build(int left, int right, int node) {
		if (left == right) {
			tree[node] = new ArrayList<>();
			tree[node].add(leaf[left]);
			return;
		}

		final int mid = (left + right) >> 1;
		final int child = node << 1;
		build(left, mid, child);
		build(mid + 1, right, child + 1);
		tree[node] = merge(tree[child], tree[child + 1]);
	}

	private static List<Integer> merge(List<Integer> a, List<Integer> b) {
		List<Integer> merged = new ArrayList<>(a.size() + b.size());

		int i = 0, j = 0;
		while (i < a.size() && j < b.size()) {
			if (a.get(i) <= b.get(j)) {
				merged.add(a.get(i++));
			} else {
				merged.add(b.get(j++));
			}
		}
		while (i < a.size()) merged.add(a.get(i++));
		while (j < b.size()) merged.add(b.get(j++));
		return merged;
	}

	private static int query(int qi, int qj, int qk, int left, int right, int node) {
		if (right < qi || qj < left) return 0;

		if (qi <= left && right <= qj) {
			return tree[node].size() - upperBound(tree[node], qk);
		}
		final int mid = (left + right) >> 1;
		final int child = node << 1;
		return query(qi, qj, qk, left, mid, child)
			+ query(qi, qj, qk, mid + 1, right, child + 1);
	}

	private static int upperBound(List<Integer> list, int target) {
		int left = 0, right = list.size();

		while (left < right) {
			int mid = (left + right) >> 1;
			if (list.get(mid) <= target) {
				left = mid + 1;
			} else {
				right = mid;
			}
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
		tree = new ArrayList[4 * N];
		build(1, N, 1);

		int Q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			sb.append(query(i, j, k, 1, N, 1)).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}