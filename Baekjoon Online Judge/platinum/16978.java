import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static long[] arr, tree;
	static List<int[]> updates = new ArrayList<>();
	static List<int[]> queries = new ArrayList<>();

	static long build(int l, int r, int node) {
		if (l == r) {
			return tree[node] = arr[l];
		}

		final int mid = (l + r) >> 1;
		return tree[node] = (build(l, mid, node * 2) + build( mid + 1, r, node * 2 + 1));
	}

	static void update(int l, int r, int node, int target, long diff) {
		if (target < l || r < target) return;

		tree[node] += diff;
		if (l == r) return;

		final int mid = (l + r) >> 1;
		update(l, mid, node * 2, target, diff);
		update(mid + 1, r, node * 2 + 1, target, diff);
	}

	static long query(int left, int right, int node, int qi, int qj) {
		if (qj < left || right < qi) return 0;
		if (qi <= left && right <= qj) return tree[node];

		final int mid = (left + right) >> 1;
		return query(left, mid, node * 2, qi, qj)
			+ query(mid + 1, right, node * 2 + 1, qi, qj);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// Input
		N = Integer.parseInt(br.readLine());
		arr = new long[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		int order = 0;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			switch (Integer.parseInt(st.nextToken())) {
				case 1:
					updates.add(new int[] {
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())
					});
					break;
				case 2:
					queries.add(new int[] {
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						order++
					});
					break;
			}
		}

		// Init
		tree = new long[4 * N];
		build(1, N, 1);
		queries.sort(Comparator.comparingInt(q -> q[0])); // q[0] is 'k'

		// Solve
		long[] answer = new long[queries.size()];
		int applied = 0;

		for (int[] q : queries) {
			int k = q[0];
			int left = q[1];
			int right = q[2];
			int idx = q[3];

			while (applied < k) {
				int[] cmd = updates.get(applied);
				int target = cmd[0];
				int value = cmd[1];

				long diff = value - arr[target];
				arr[target] = value;
				update(1, N, 1, target, diff);

				++applied;
			}

			answer[idx] = query( 1, N, 1, left, right);
		}

		// Output
		StringBuilder sb = new StringBuilder();
		for (long value : answer) {
			sb.append(value).append('\n');
		}
		System.out.print(sb);
	}
}