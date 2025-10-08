import java.io.*;
import java.util.*;

public class Main {
	private static int solve(char[] S) {
		boolean isPalindrome = true;
		for (int i = 0; i < (S.length >> 1); ++i) {
			if (S[i] != S[S.length - 1 - i]) {
				isPalindrome = false;
				break;
			}
		}

		boolean allSame = true;
		if (isPalindrome) {
			for (int i = 1; i < S.length; ++i) {
				if (S[i] != S[0]) {
					allSame = false;
					break;
				}
			}
			return allSame ? -1 : S.length - 1;
		}
		return S.length;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Solve
		System.out.println(solve(br.readLine().toCharArray()));
	}
}