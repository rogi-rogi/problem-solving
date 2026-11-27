import java.io.*;
import java.util.*;

public class Main {
	private static boolean solve(long N) {
		if (N % 8 != 0) {
			return false;
		}

		N /= 8;
		char[] num = String.valueOf(N).toCharArray();

		char prevNum = '0';
		for (int i = 0; i < num.length; ++i) {
			if (num[i] < prevNum || num[i] > '8') {
				return false;
			}
			prevNum = num[i];
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			long N = Long.parseLong(br.readLine());

			// Solve
			sb.append(solve(N) ? "Yes" : "No").append('\n');
		}

		// Output
		System.out.println(sb);
	}
}