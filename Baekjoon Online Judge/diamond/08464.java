import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MAX = 200000;
	static int[] mobius = new int[MAX + 1];

	static long countSquareFree(long x) {
		long count = 0;
		for (int i = 1; (long) i * i <= x; i++) {
			count += (long) mobius[i] * (x / ((long) i * i));
		}
		return count;
	}

	static long countNonSquareFree(long x) {
		return x - countSquareFree(x);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		long K = Long.parseLong(br.readLine());

		// Solve
		mobius[1] = 1;
		for (int i = 1; i <= MAX; i++) {
			for (int j = i + i; j <= MAX; j += i) {
				mobius[j] -= mobius[i];
			}
		}

		long left = 0;
		long right = 1;

		while (countNonSquareFree(right) < K) {
			right <<= 1;
		}

		while (left + 1 < right) {
			long mid = (left + right) >>> 1;
			if (countNonSquareFree(mid) >= K) {
				right = mid;
			} else {
				left = mid;
			}
		}

		// Output
		System.out.print(right);
	}
}