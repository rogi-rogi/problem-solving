import java.io.*;

public class Main {
	static int N;
	static int[] nums;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	private static void permutation(int[] nums, final boolean[] visited, final int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; ++i)
				sb.append(nums[i]).append(' ');
			sb.append('\n');
		}
		for (int i = 1; i <= N; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				nums[cnt] = i;
				permutation(nums, visited, cnt + 1);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// Init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		N = Integer.parseInt(br.readLine());

		// Solve
		nums = new int[N + 1];
		visited = new boolean[N + 1];
		permutation(nums, visited, 0);

		// Output
		System.out.println(sb);
	}
}