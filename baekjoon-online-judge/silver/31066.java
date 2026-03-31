import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			// Solve
			if (M == 1 && K == 1) {
				sb.append(N == 1 ? "1" : "-1").append("\n");
				continue;
			}
			int cnt = 0;
			while (N > 0) {
				N -= M*K;
				++cnt;
				if (N > 0) {
					++N;
					++cnt;
				}
			}
			sb.append(cnt).append("\n");
		}

		// Output
		System.out.print(sb);
	}
}
