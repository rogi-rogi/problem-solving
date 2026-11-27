import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int C = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (C-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int l1 = Integer.parseInt(st.nextToken());
			int l2 = Integer.parseInt(st.nextToken());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());

			int[] pass1to2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] dribble1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] pass2to1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] dribble2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			// Solve
			int[] dp = {l1, l2}; // 다음 단계에서 idx번 선수에게 공이 있도록 만드는 최소 비용

			for (int i = 0; i < N - 1; ++i) {
				int nextDp1 = Math.min(dp[0] + dribble1[i], dp[1] + pass2to1[i]);
				int nextDp2 = Math.min(dp[1] + dribble2[i], dp[0] + pass1to2[i]);

				dp[0] = nextDp1;
				dp[1] = nextDp2;
			}

			long answer = Math.min(dp[0] + s1, dp[1] + s2);
			sb.append(answer).append("\n");
		}

		// Output
		System.out.print(sb);
	}
}