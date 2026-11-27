import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		final int LEN = 2 * N;
		int[] P = new int[LEN];
		for (int i = 0; i < LEN; i += 2) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());

			// Solve
			P[i] = Integer.parseInt(st.nextToken());	// start
			for (int k = 2; k < K; ++k) st.nextToken();
			P[i + 1] = Integer.parseInt(st.nextToken()); // end
		}
		Arrays.sort(P);

		// Output
		System.out.print(P[N - 1]); // (LEN / 2) - 1
	}
}
