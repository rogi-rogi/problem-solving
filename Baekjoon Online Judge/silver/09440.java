import java.io.*;
import java.util.*;

public class Main {
	private static int solve(int[] A, int N) {
		int[] count = new int[10];
		for (int i = 0; i < N; ++i) {
			++count[A[i]];
		}

		int[] nums = new int[2];
		for (int idx = 0; idx < 2; ++idx) {
			for (int i = 1; i <= 9; ++i) {
				if (count[i] > 0) {
					--count[i];
					nums[idx] = i;
					break;
				}
			}
		}

		boolean isLeft = true;
		for (int i = 0; i <= 9; ++i) {
			while (count[i]-- > 0) {
				if (isLeft) {
					nums[0] = nums[0] * 10 + i;
				} else {
					nums[1] = nums[1] * 10 + i;
				}
				isLeft = !isLeft;
			}
		}

		return nums[0] + nums[1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			// Input
			String[] in =  br.readLine().split(" ", 2);
			final int N = Integer.parseInt(in[0]);
			if (N == 0) break;
			int[] A = Arrays.stream(in[1].split(" ")).mapToInt(Integer::parseInt).toArray();

			// Solve
			sb.append(solve(A, N)).append("\n");
		}

		// Output
		System.out.println(sb);
	}
}