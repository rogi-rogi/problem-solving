import java.io.*;
import java.util.*;


public class Main {

	private static boolean solve(int[] A) {
		for (int i = 1; i < A.length; ++i) {
			if (A[i] > A[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int M = Integer.parseInt(br.readLine().split(" ")[1]);

		// Solve
		while (M > 0) {
			br.readLine();
			int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if (!solve(A)) break;
			--M;
		}

		// Output
		System.out.println(M == 0 ? "Yes" : "No");
	}
}