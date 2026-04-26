import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static Point[] points;

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static long getDist(Point a, Point b) {
		long dx = a.x - b.x;
		long dy = a.y - b.y;
		return dx * dx + dy * dy;
	}

	static long solve() {
		for (int i = 1; i < N; i++) {
			if (points[i - 1].x == points[i].x && points[i - 1].y == points[i].y) {
				return 0;
			}
		}

		TreeSet<Point> candidates = new TreeSet<>((a, b) -> {
			if (a.y != b.y) return Integer.compare(a.y, b.y);
			return Integer.compare(a.x, b.x);
		});
		candidates.add(points[0]);
		candidates.add(points[1]);

		long minDist = getDist(points[0], points[1]);
		int start = 0;
		for (int i = 2; i < N; ++i) {
			Point now = points[i];

			while (start < i) {
				Point prev = points[start];
				long dx = now.x - prev.x;

				if (dx * dx > minDist) {
					candidates.remove(prev);
					++start;
				} else break;
			}

			final int D = (int) Math.sqrt(minDist) + 1; // safety margin
			Point lower = new Point(Integer.MIN_VALUE, now.y - D);
			Point upper = new Point(Integer.MAX_VALUE, now.y + D);

			for (Point p : candidates.subSet(lower, true, upper, true)) {
				minDist = Math.min(minDist, getDist(now, p));
			}
			candidates.add(now);
		}
		return minDist;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		N = Integer.parseInt(br.readLine());
		points = new Point[N];
		StringTokenizer st;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
			);
		}

		// Solve
		Arrays.sort(points, (a, b) -> {
			if (a.x != b.x) return Integer.compare(a.x, b.x);
			return Integer.compare(a.y, b.y);
		});

		// Output
		System.out.print(solve());
	}
}