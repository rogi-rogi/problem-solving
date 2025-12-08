import static java.util.Collections.*;

import java.io.*;
import java.util.*;

public class Main {

	private static void swap(char[] S, int a, int b) {
		char temp = S[a];
		S[a] = S[b];
		S[b] = temp;
	}

	private static void reverse(char[] S, int left, int right) {
		while (left < right) {
			swap(S, left, right);
			++left;
			--right;
		}
	}

	private static String nextPermutation(char[] S) {
		int breakPointIdx = S.length - 2;
		while (breakPointIdx >= 0 && S[breakPointIdx] >= S[breakPointIdx + 1]) {
			--breakPointIdx;
		}
		if (breakPointIdx < 0) {
			return new String(S);
		}

		int nextGreaterIdx =  S.length - 1;
		while (S[nextGreaterIdx] <= S[breakPointIdx]) {
			--nextGreaterIdx;
		}

		swap(S, breakPointIdx, nextGreaterIdx);
		reverse(S, breakPointIdx + 1, S.length - 1);
		return new String(S);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			// Solve
			sb.append(nextPermutation(br.readLine().toCharArray())).append("\n");
		}

		// Output
		System.out.println(sb);
	}
}