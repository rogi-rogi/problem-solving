import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String[] input = br.readLine().split(" ");
			final int L = Integer.parseInt(input[0]);
			int N = Integer.parseInt(input[1]);
			int min = 0, max = 0;
			while (N-- > 0) {
				final int a = Integer.parseInt(br.readLine());

				// Solve
				min = Math.max(min, Math.min(a, L - a));
				max = Math.max(max, Math.max(a, L - a));
			}
			sb.append(min).append(" ").append(max).append("\n");

		}

		// Output
		System.out.println(sb);
	}
}