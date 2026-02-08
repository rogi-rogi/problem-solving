import java.io.*;
import java.util.*;


public class Main {
	private static int solve(long K) {
		if (K == 0) {
			return 0;
		}
		if (K % 2 == 0) {
			return -1;
		}
		int cnt = 1;
		for (long cur = 1, jump = 1; cur < K; cur += jump) {
			jump <<= 1;
			++cnt;
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final long K = Math.abs(Long.parseLong(br.readLine()));

		// Solve & Output
		System.out.print(solve(K));
	}
}