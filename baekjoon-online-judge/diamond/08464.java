import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MAX = 42000;

	static int[] mobius = new int[MAX + 1];

	static long countSquareFree(long x) {
		long count = 0;
		for (int i = 1; (long) i * i <= x; i++) {
			count += mobius[i] * (x / ((long) i * i));
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		long K = Long.parseLong(br.readLine());

		// Solve
		mobius[1] = 1;
		for (int i = 1; i <= MAX; i++) {
			for (int j = 2 * i; j <= MAX; j += i) {
				mobius[j] -= mobius[i];
			}
		}

		long left = 0;
		long right = K * 2;

		while (left < right - 1) {
			long mid = (left + right) / 2;
			if (countSquareFree(mid) < K) {
				left = mid;
			} else {
				right = mid;
			}
		}

		// Output
		System.out.print(right);
	}
}