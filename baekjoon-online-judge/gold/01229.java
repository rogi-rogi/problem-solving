import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());

		// Solve
		List<Integer> hex = new ArrayList<>();
		for (int i = 1; ; ++i) {
			int h = i * (2 * i - 1);
			if (h > N) break;
			hex.add(h);
		}

		int[] dp = new int[N + 1];
		Arrays.fill(dp, 6);

		dp[0] = 0;
		for (int i = 1; i <= N; ++i) {
			for (int h : hex) {
				if (h > i) break;
				dp[i] = Math.min(dp[i], dp[i - h] + 1);
			}
		}

		// Output
		System.out.print(dp[N]);
	}
}