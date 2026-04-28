import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());

		// Solve
		long[] A = new long[N + 1];
		for (int i = 1; i <= M; ++i) {
			st = new StringTokenizer(br.readLine());
			final int L = Integer.parseInt(st.nextToken());
			final int R = Integer.parseInt(st.nextToken());
			for (int j = L; j <= R; ++j) {
				A[j] = i;
			}
		}

		Set<Long> set = new HashSet<>();
		for (long a : A) {
			set.add(a);
		}

		// Output
		System.out.println((long) Math.pow(2, set.size() - 1));
	}
}