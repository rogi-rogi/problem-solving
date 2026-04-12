import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// Input
		int N = Integer.parseInt(br.readLine());
		boolean[][] line = new boolean[101][101];
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			line[a][b] = true;
		}

		// Solve
		int[][] dp = new int[101][101];
		for (int len = 1; len <= 100; ++len) {
			for (int l = 1; l + len - 1 <= 100; ++l) {
				int r = l + len - 1;

				dp[l][r] = dp[l][r - 1];
				for (int k = l; k < r; ++k) {
					if (!line[k][r]) continue;

					int left = (k - 1 >= 1 ? dp[l][k - 1] : 0);
					int inside = (k + 1 <= r - 1 ? dp[k + 1][r - 1] : 0);
					dp[l][r] = Math.max(dp[l][r], left + 1 + inside);
				}
			}
		}

		// Output
		System.out.print(dp[1][100]);
	}
}
