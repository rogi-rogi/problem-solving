import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		double x, y;
		Point(double x, double y) { this.x = x; this.y = y; }
	}

	static double dist(Point p, Point q) {
		double dx = p.x - q.x;
		double dy = p.y - q.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	static double ccw(Point a, Point b, Point c) {
		double abx = b.x - a.x;
		double aby = b.y - a.y;
		double acx = c.x - a.x;
		double acy = c.y - a.y;
		return abx * acy - aby * acx;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		Point A = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		Point B = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		Point C = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

		// Solve
		if (ccw(A, B, C) == 0.0) {
			System.out.println("-1.0");
			return;
		}

		double ab = dist(A, B);
		double ac = dist(A, C);
		double bc = dist(B, C);

		double p1 = 2 * (ab + ac);
		double p2 = 2 * (ab + bc);
		double p3 = 2 * (ac + bc);

		double maxP = Math.max(p1, Math.max(p2, p3));
		double minP = Math.min(p1, Math.min(p2, p3));

		// Output
		System.out.println(maxP - minP);
	}
}
