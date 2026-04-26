import java.io.*;
import java.util.*;

public class Main {
	private static String solve(int A, int B, int C) {
		if (B % A != 0 || C % A != 0 || B * B - 4 * A * C <= 0) {
			return "둘다틀렸근";
		}
		B /= A;
		C /= A;
		int[] twoK = new int[]{2, 4, 8, 16, 32, 64, 128, 256};
		for (int first : twoK) {
			for (int second : twoK) {
				if (first == second) {
					continue;
				}
				if (first + second == -B && first * second == C) {
					return "이수근";
				}
			}
		}
		for (int i = -200; i <= 200; ++i) {
			for (int j = -200; j <= 200; ++j) {
				if (i + j == -B && i * j == C) {
					return "정수근";
				}
			}
		}
		return "둘다틀렸근";
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int A = Integer.parseInt(st.nextToken());
		final int B = Integer.parseInt(st.nextToken());
		final int C = Integer.parseInt(st.nextToken());

		// Solve & Output
		System.out.println(solve(A, B, C));
	}
}