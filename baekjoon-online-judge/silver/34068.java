import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int M = Integer.parseInt(in[1]);
		int[] cnt = new int[N];
		while (M-- > 0) {
			in = br.readLine().split(" ");
			int A = Integer.parseInt(in[0]);

			// Solve
			++cnt[A - 1];
		}
		Arrays.sort(cnt);

		long result = 0;
		for (int i = 1; i < N; ++i) {
			if (cnt[i] <= cnt[i - 1]) {
				result += (cnt[i - 1] + 1 - cnt[i]);
				cnt[i] = cnt[i - 1] + 1;
			}
		}

		// Output
		System.out.print(result);
	}
}
