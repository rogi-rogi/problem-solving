import java.io.*;
import java.util.*;

public class Main {
	private static int GCD(int a, int b) {
		return b == 0 ? a : GCD(b, a % b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());

		// Solve
		/*
		f(R) = f(x, y) = x + y - gcd(x, y) = N
		gcd(x, y) = G
		x = Ga, y = Gb
		gcd(a, b) = 1
		Ga + Gb - G = N
		a + b = 1 + (N / G), a <= b
		 */
		int cnt = 0;
		for (int G = 1; G <= N; ++G) {
			if (N % G == 0) {
				final int r = 1 + (N / G);
				final int aRange = r / 2;
				for (int a = 1; a <= aRange; ++a) {
					final int b = r - a;
					if (GCD(a, b) == 1) ++cnt;
				}
			}
		}

		// Output
		System.out.println(cnt);
	}
}