import java.io.*;
import java.util.*;

public class Main {
	static final long MAX = (1L << 32) - 1;

	private static String solve(long[] M) {
		for (int i = 0; i < Math.min(4, M.length); ++i) {
			if (M[i] != i) return "SNAIL";
		}
		if (M.length <= 4) return "NAUTILUS";

		long sum = M[0] + M[1] + M[2] + M[3];

		for (int i = 4; i < M.length; ++i) {
			if (sum > MAX) return "SNAIL";
			if (M[i] != sum) return "SNAIL";

			sum = sum - M[i - 4] + M[i];
		}
		return "NAUTILUS";
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			long[] M = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

			// Solve
			sb.append(solve(M)).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}
