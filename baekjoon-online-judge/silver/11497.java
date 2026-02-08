import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			final int N = Integer.parseInt(br.readLine());
			int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			// Solve
			Arrays.sort(A);
			int[] B = new int[N];
			for (int i = 0; i < N; ++i) {
				B[i % 2 == 0 ? i / 2 : N - (i / 2) - 1] = A[i];
			}
			int maxDiff = B[N - 1] - B[0];
			for (int i = 1; i < N; ++i) {
				maxDiff = Math.max(maxDiff, Math.abs(B[i] - B[i - 1]));
			}
			sb.append(maxDiff).append("\n");
		}


		// Output
		System.out.println(sb);
	}
}