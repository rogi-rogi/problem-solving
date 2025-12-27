import java.io.*;
import java.util.*;

public class Main {
	private static long solve(long X, long Y) {
		long Z = 100 * Y / X;
		if (Z >= 99) {
			return -1;
		}

		long left = 1, right = (long) 1e9;
		long result = -1;
		while (left <= right) {
			long mid = (left + right) / 2;
			long newZ = (100 * (Y + mid)) / (X + mid);
			if (newZ > Z) {
				right = mid - 1;
				result = mid;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		int X = Integer.parseInt(in[0]);
		int Y = Integer.parseInt(in[1]);

		// Solve & Output
		System.out.println(solve(X, Y));
	}
}