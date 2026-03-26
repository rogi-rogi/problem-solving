import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		long[] A = new long[N];
		st = new StringTokenizer(br.readLine());

		long X0 = Long.MIN_VALUE;
		for (int i = 0; i < N; ++i) {
			A[i] = Long.parseLong(st.nextToken());

			// Solve
			X0 = Math.max(X0, A[i] - i * K);
		}

		long ans = 0;
		for (int i = 0; i < N; ++i) {
			ans += (X0 + i * K) - A[i];
		}

		// Output
		System.out.print(ans);
	}
}