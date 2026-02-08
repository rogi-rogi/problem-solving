import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		final int K = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String[] input = br.readLine().split(" ");
			final int M = Integer.parseInt(input[0]);
			final int N = Integer.parseInt(input[1]);

			// Solve
			if (M == N) {
				sb.append("1\n");
			} else if (M < N) {
				sb.append(M + (K - (N - 1)) > (N - 1) ? "1\n" : "0\n");
			} else { // M > N
				sb.append(N + (K - (M - 1)) + 1 > (M - 1) ? "1\n" : "0\n");
			}
		}

		// Output
		System.out.println(sb);
	}
}