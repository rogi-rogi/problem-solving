import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] input = br.readLine().split(" ");
		final int H = Integer.parseInt(input[0]);
		final int N = Integer.parseInt(input[1]);

		final int SIZE = Math.abs(H - N);
		long[][] dp = new long[SIZE + 1][SIZE + 1];

		// Solve
		for (int i = 0; i <= SIZE; ++i) {
			dp[0][i] = 1;
		}

		for (int i = 1; i <= SIZE; ++i) {
			for (int j = i; j <= SIZE; ++j) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		// Output
		System.out.println(dp[SIZE][SIZE]);
	}
}