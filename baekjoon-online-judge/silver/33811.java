import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();

		// Solve
		int[] dp = new int[N + 1];
		for (int i = 3; i < N; ++i) {
			String subStr = S.substring(i - 3, i + 1);
			if (subStr.equals("SSHS")) {
				dp[i + 1] = 1;
			} else if (subStr.equals("GSHS")) {
				dp[i + 1] = -1;
			}
		}
		int cnt = 0, result = 0;
		for (int i = 1; i <= N; ++i) {
			cnt += dp[i];
			if (cnt < 0) {
				cnt = 0;
			}
			result = Math.max(result, cnt);
		}

		// Output
		System.out.print(result);
	}
}