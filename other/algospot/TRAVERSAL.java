import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Map<Integer, Integer> inorderIndexMap;

	private static void solve(int[] preorder, int preL, int preR, int inL, int inR) {
		if (preL >= preR || inL >= inR)
			return;

		final int root = preorder[preL];
		final int inorderRoot = inorderIndexMap.get(root);
		final int left = inorderRoot - inL;

		solve(preorder, preL + 1, preL + 1 + left, inL, inorderRoot);
		solve(preorder, preL + 1 + left, preR, inorderRoot + 1, inR);

		sb.append(root).append(" ");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			final int N = Integer.parseInt(br.readLine());
			int[] preorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] inorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			inorderIndexMap = new HashMap<>();
			for (int i = 0; i < N; i++) {
				inorderIndexMap.put(inorder[i], i);
			}
			// Solve
			solve(preorder, 0, N, 0, N);
			sb.append("\n");
		}

		// Output
		System.out.println(sb);
	}
}