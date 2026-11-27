import java.io.*;
import java.util.*;

public class Main {
	static int getMin(int[] cnt) {
		for (int i = 1; i <= 10; ++i)
			if (cnt[i] > 0)
				return i;
		return 0;
	}

	static int getMax(int[] cnt) {
		for (int i = 10; i >= 1; i--)
			if (cnt[i] > 0)
				return i;
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		int[] cnt = new int[11];
		++cnt[A[0]];

		int l = 0, len = 1;
		for (int r = 1; r < N; ++r) {
			++cnt[A[r]];

			while (getMax(cnt) - getMin(cnt) > 2) {
				--cnt[A[l]];
				++l;
			}

			len = Math.max(len, r - l + 1);
		}

		// Output
		System.out.print(len);
	}
}
