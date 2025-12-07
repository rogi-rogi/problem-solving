import java.io.*;
import java.util.*;

public class Main {
	static Set<String> set;
	static int[] maxIntervalRight, minIntervalLeft;

	private static int solve(String query) {
		if (set.contains(query)) {
			return 1;
		}

		String[] in = query.split(" ");
		int l = Integer.parseInt(in[0]);
		int r = Integer.parseInt(in[1]);
		if (minIntervalLeft[r] != Integer.MAX_VALUE &&
			maxIntervalRight[l] > r && minIntervalLeft[r] < l
		) {
			return 2;
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int N = Integer.parseInt(br.readLine());
		set = new HashSet<>((int) 4e5);
		final int SIZE = (int) 1e6 + 1;
		maxIntervalRight = new int[SIZE];
		minIntervalLeft = new int[SIZE];
		Arrays.fill(minIntervalLeft, Integer.MAX_VALUE);

		while (N-- > 0) {
			String in = br.readLine();
			set.add(in);
			String[] temp = in.split(" ");
			int l = Integer.parseInt(temp[0]);
			int r = Integer.parseInt(temp[1]);

			// Solve
			maxIntervalRight[l] = Math.max(maxIntervalRight[l], r);
			minIntervalLeft[r] = Math.min(minIntervalLeft[r], l);
		}
		int Q = Integer.parseInt(br.readLine());
		while (Q-- > 0) {
			sb.append(solve(br.readLine())).append("\n");
		}

		// Output
		System.out.println(sb);
	}
}