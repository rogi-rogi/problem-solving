import java.io.*;
import java.util.*;


public class Main {
	private static int gcd(int a, int b) {
		return b > 0 ? gcd(b, a % b) : a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			final int N = Integer.parseInt(br.readLine());
			int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			// Solve
			Arrays.sort(A);
			int[] diff = new int[N - 1];
			for (int i = 0; i < N - 1; ++i) {
				diff[i] = A[i + 1] - A[i];
			}
			int commonGCD = diff[0];
			for (int i = 1; i < N - 1; ++i) {
				commonGCD = gcd(commonGCD, diff[i]);
			}
			if (commonGCD == 0) {
				sb.append("INFINITY\n");
			} else {
				sb.append(commonGCD).append("\n");
			}
		}

		// Output
		System.out.println(sb);
	}
}