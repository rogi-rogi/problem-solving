import java.io.*;
import java.util.*;

public class Main {
	static final int MOD = (int) 1e9 + 7;

	static int solve(int G, int D) {
		int[] dp = new int[G + D + 1];
		dp[0] = 1;

		long sum = 1;
		for (int i = 1; i <= G; ++i) {
			dp[i] = (int) sum;

			sum = (sum + dp[i]) % MOD;
			if (i - D >= 0) {
				sum -= dp[i - D];
				if (sum < 0) sum += MOD;
			}
		}
		return dp[G];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int G = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			// Solve
			sb.append(solve(G, D)).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}