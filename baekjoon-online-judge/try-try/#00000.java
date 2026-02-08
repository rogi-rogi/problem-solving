import java.io.*;
import java.util.*;

public class Main {
	static final long INIT = Long.MIN_VALUE / 4;
	static final int NONE = 0,   // i번째에 타워 없음
		FREE = 1,   // i번째에 타워 있음, 연결 안 함
		USED = 2;   // i번째에 타워 있음, i-1과 이미 연결

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		long[] A = new long[N + 1];
		long[] B = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			A[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N; ++i) {
			B[i] = Long.parseLong(st.nextToken());
		}

		long[][] dp = new long[3][N + 1];
		for (int s = 0; s < 3; ++s) {
			Arrays.fill(dp[s], INIT);
		}

		dp[NONE][0] = 0;
		dp[FREE][1] = A[1];

		for (int i = 1; i < N; i++) {
			int next = i + 1;

			long[][] ndp = new long[3][N + 1];
			for (int s = 0; s < 3; ++s) Arrays.fill(ndp[s], INIT);

			for (int k = 0; k <= i; ++k) {
				for (int state = 0; state < 3; ++state) {
					long v = dp[state][k];
					if (v <= INIT) continue;
					ndp[NONE][k] = Math.max(ndp[NONE][k], v);
					ndp[FREE][k + 1] = Math.max(ndp[FREE][k + 1], v + A[next]);
					if (state == FREE) {
						ndp[USED][k + 1] = Math.max(ndp[USED][k + 1], v + A[next] + B[i]);
					}
				}
			}
			dp = ndp;
		}

		// Output
		StringBuilder sb = new StringBuilder();
		for (int k = 1; k <= N; ++k) {;
			sb.append(
				Math.max(dp[NONE][k], Math.max(dp[FREE][k], dp[USED][k]))
			).append('\n');
		}
		System.out.print(sb);
	}
}