import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		public final long x, y;
		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int ccw(Point a, Point b, Point c) {
		long abx = b.x - a.x;
		long aby = b.y - a.y;
		long acx = c.x - a.x;
		long acy = c.y - a.y;

		long cross = abx * acy - aby * acx;
		if (cross > 0) return 1;
		if (cross < 0) return -1;
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < 3; ++i) {
			String[] in = br.readLine().split(" ");
			int X = Integer.parseInt(in[0]);
			int Y = Integer.parseInt(in[1]);
			list.add(new Point(X, Y));
		}

		// Solve & Output
		System.out.println(ccw(list.get(0), list.get(1), list.get(2)));
	}
}