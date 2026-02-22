import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				A[i] = Integer.parseInt(br.readLine());
			}

			// Solve
			boolean[] visited = new boolean[N + 1];
			int cur = 1;
			int cnt = 0;
			while (!visited[cur] && cur != N) {
				visited[cur] = true;
				cur = A[cur];
				++cnt;
			}
			sb.append(cur == N ? cnt : 0).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}