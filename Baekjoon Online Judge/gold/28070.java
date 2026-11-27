import java.io.*;
import java.util.*;

public class Main {

	private static int toIndex(String s) {
		int year = Integer.parseInt(s.substring(0, 4));
		int month = Integer.parseInt(s.substring(5, 7));
		return year * 12 + (month - 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		int MAX = 9999 * 12 + 11;
		int[] diff = new int[MAX + 2];

		// Solve
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = toIndex(st.nextToken());
			int end = toIndex(st.nextToken());

			++diff[start];
			--diff[end + 1];
		}

		int cur = 0, max = 0;
		int result = 0;

		for (int i = 0; i <= MAX; ++i) {
			cur += diff[i];
			if (cur > max) {
				max = cur;
				result = i;
			}
		}

		// Output
		System.out.printf("%04d-%02d%n", result / 12, result % 12 + 1);
	}
}