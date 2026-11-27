import java.io.*;
import java.util.*;

public class Main {

	private static long solve(long[] C) {
		List<Long> list = new ArrayList<>();
		for (long c : C) {
			list.add(c);
		}
		PriorityQueue<Long> pq = new PriorityQueue<>(list);

		long result = 1;
		int MOD = (int) 1e9 + 7;
		while (pq.size() > 1) {
			long mul = pq.poll() * pq.poll();
			result = (result * (mul % MOD)) % MOD;
			pq.add(mul);
		}
		return result % MOD;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			br.readLine();
			long[] C = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

			// Solve
			sb.append(solve(C)).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}
