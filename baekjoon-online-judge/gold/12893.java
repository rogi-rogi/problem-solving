import java.io.*;
import java.util.*;

public class Main {
	static int[] parent, size;

	private static int find(int x) {
		while (x != parent[x]) {
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		return x;
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb) return;
		if (size[pa] < size[pb]) {
			int tmp = pa;
			pa = pb;
			pb = tmp;
		}
		parent[pb] = pa;
		size[pa] += size[pb];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// Solve
		int MAX = 2 * N;
		parent = new int[MAX];
		size = new int[MAX];
		for (int i = 0; i < MAX; ++i) {
			parent[i] = i;
			size[i] = 1;
		}

		int result = 1;
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			union(A, B + N);
			union(A + N, B);

			if (find(A) == find(A + N) || find(B) == find(B + N)) {
				result = 0;
				break;
			}
		}

		// Output
		System.out.print(result);
	}
}
