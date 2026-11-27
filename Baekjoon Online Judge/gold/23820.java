import java.io.*;
import java.util.*;

public class Main {
	static final int MAX_PRIME = (int) 2e6 + 3;
	static int N;
	static boolean[] nums, result;

	private static long solve() {
		if (!nums[0]) return 0;

		for (int i = 1; i <= MAX_PRIME; ++i) {
			if (nums[i]) {
				for (int j = 1; j <= MAX_PRIME / i; ++j) {
					if (nums[j]) {
						result[i * j] = true;
					}
				}
			}
		}
		for (int i = 1; i <= MAX_PRIME; ++i) {
			if (!result[i]) return i;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		nums = new boolean[MAX_PRIME + 1];
		result = new boolean[MAX_PRIME + 1];
		N = Integer.parseInt(br.readLine());
		for (int i :Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
			nums[i] = true;
		}

		// Solve & Output
		System.out.println(solve());
	}
}