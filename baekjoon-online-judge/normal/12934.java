import java.io.*;
import java.util.*;

public class Main {
	private static long solve(final long X, final long Y) {
		final long N = (long) Math.sqrt(2 * (X + Y));
		if (N * (N + 1) / 2 != X + Y) {
			return -1;
		}

		long sum = 0L, cnt = 0L;
		for (long i = N; i >= 1; --i) {
			if (sum + i <= X) {
				sum += i;
				++cnt;
				if (sum == X) break;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in =  br.readLine().split(" ");

		final long X = Long.parseLong(in[0]);
		final long Y = Long.parseLong(in[1]);

		// Solve & Output
		System.out.println(solve(X, Y));
	}
}