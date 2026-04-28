import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		// Init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		final int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; ++i) {
			// Solve
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			int max = Math.max(a*a, Math.max(b*b, c*c));
			int sumOfOthers = a*a + b*b + c*c - max;

			sb.append(String.format("Case #%d: %s\n", i, (max == sumOfOthers ? "YES" : "NO")));
		}

		// Output
		System.out.println(sb);
	}
}