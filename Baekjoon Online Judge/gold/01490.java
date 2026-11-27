import java.io.*;
import java.util.*;

public class Main {

	static boolean isValid(long candidate, long base) {
		while (base > 0) {
			long digit = base % 10;
			if (digit != 0 && candidate % digit != 0) return false;
			base /= 10;
		}
		return true;
	}

	static long solve(long N) {
		Queue<Long> queue = new ArrayDeque<>();
		queue.add(N);

		long cur = -1;
		while (!queue.isEmpty()) {
			cur = queue.poll();

			if (isValid(cur, N)) {
				return cur;
			}

			for (int i = 0; i <= 9; ++i) {
				queue.add(cur * 10 + i);
			}
		}
		return cur;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		long N = Long.parseLong(br.readLine());

		// Solve & Output
		System.out.print(solve(N));
	}
}