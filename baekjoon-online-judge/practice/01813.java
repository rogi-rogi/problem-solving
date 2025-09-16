import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		int res = -1;
		for (int i = 0; i <= N; ++i) {
			int cnt = 0;
			for (int a : A) {
				if (a == i) {
					++cnt;
				}
			}

			if (cnt == i) {
				res = Math.max(res, cnt);
			}
		}

		// Output
		System.out.println(res);
	}
}