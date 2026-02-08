import java.io.*;
import java.util.*;

public class Main {

	private static boolean solve(int[] A, int K) {
		int[] suffixMin = new int[A.length];
		suffixMin[A.length - 1] = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; --i) {
			suffixMin[i] = Math.min(suffixMin[i + 1], A[i]);
		}

		for (int i = 0; i < A.length - 1; ++i) {
			if (A[i] > suffixMin[i + 1] && A[i] - suffixMin[i + 1] > K) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		final int K = Integer.parseInt(in[1]);
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve & Output
		System.out.println(solve(A, K) ? "YES" : "NO");
	}
}