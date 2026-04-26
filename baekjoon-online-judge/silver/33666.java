import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// Input
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		final int M = Integer.parseInt(st.nextToken());
		int[] P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		int[] cnt = new int[M];
		long sum = 0;
		int avgUpCnt = 0;
		for (int p : P) {
			if (p >= 2) {
				++avgUpCnt;
				sum += p;
			}
		}

		double avg = avgUpCnt > 0 ? (double) sum / avgUpCnt : 0;
		for (int p : P) {
			if (p <= avg) {
				if (p > M) {
					System.out.print(-1);
					return;
				}
				++cnt[p - 1];
			} else {
				++cnt[0];
			}
		}
		for (int i = M - 2; i >= 0; --i) {
			cnt[i] += cnt[i + 1];
		}

		for (int i = 0; i < M; i++) {
			sb.append(cnt[i]).append(" ");
		}

		// Output
		System.out.print(sb);
	}
}