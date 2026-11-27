import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 52, TYPE_MAX = 13, MOD = (int)1e4 + 7;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());

		// Solve
		int[][] dp = new int[MAX + 1][MAX + 1];
		for (int i = 0; i <= MAX; ++i) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= MAX; ++i) {
			for (int j = 1; j <= MAX; ++j) {
				dp[i][j] = (dp[i - 1][j] + dp[i -1][j - 1]) % MOD;
			}
		}

		int result = 0;
		for(int i = 1; i <= TYPE_MAX && N - 4 * i >= 0; ++i) {
			if(i % 2 == 1)
				result = ((result + dp[MAX - 4 * i][N - 4 * i] * dp[TYPE_MAX][i]) % MOD) % MOD;
			else
				result = (result - (dp[MAX - 4 * i][N - 4 * i] * dp[TYPE_MAX][i]) % MOD + MOD) % MOD;
		}

		// Output
		System.out.print(result);
	}
}
