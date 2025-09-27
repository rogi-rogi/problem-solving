import java.io.*;
import java.util.*;


public class Main {
	private static boolean solve(char[] S, int[] alpha, int N) {
		if (N % 2 == 1) {
			--alpha[S[N / 2] - 'a'];
		}
		for (int cnt : alpha) {
			if (cnt % 2 == 1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());
		char[] S =  br.readLine().toCharArray();

		// Solve
		int[] alpha = new int[26];
		for (char c : S) {
			++alpha[c - 'a'];
		}

		// Output
		System.out.println(solve(S, alpha, N) ? "Yes" : "No");
	}
}