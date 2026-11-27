import java.io.*;
import java.util.*;

public class Main {

	private static int solve(String in) {
		int[] cnt = new int[2];
		for (int i = 0; i < in.length(); ++i) {
			++cnt[in.charAt(i) - 'a'];
		}
		return Math.min(cnt[0], cnt[1]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			// Solve
			sb.append(solve(br.readLine())).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}
