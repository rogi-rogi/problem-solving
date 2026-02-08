import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		final int N = Integer.parseInt(in[0]);
		final int M = Integer.parseInt(in[1]);
		final int K = Integer.parseInt(in[2]);

		// Solve
		if (N + M - 1 > K) {
			System.out.println("NO");
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("YES\n");
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				sb.append(i + (j + 1)).append(" ");
			}
			sb.append("\n");
		}

		// Output
		System.out.println(sb);
	}
}