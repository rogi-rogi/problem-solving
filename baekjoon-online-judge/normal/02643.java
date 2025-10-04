import java.io.*;
import java.util.*;

public class Main {
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = Math.min(x, y);
			this.y = Math.max(x, y);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());
		List<Point> A = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			String[] in  = br.readLine().split(" ");
			final int x = Integer.parseInt(in[0]);
			final int y = Integer.parseInt(in[1]);
			A.add(new Point(x, y));
		}

		// Solve
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		A.sort((a, b) -> {
			if (a.x == b.x) {
				return Integer.compare(a.y, b.y);
			}
			return Integer.compare(a.x, b.x);
		});

		int res = 0;
		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < i; ++j) {
				if (A.get(i).x >= A.get(j).x && A.get(i).y >= A.get(j).y) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}


		// Output
		System.out.println(res);
	}
}