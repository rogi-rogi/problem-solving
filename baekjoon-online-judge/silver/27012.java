import java.io.*;
import java.util.*;

public class Main {

	private static int solve(int[] days, long target, int D) {
		long sum = 0;
		int day = D;
		for (; day >= 1; --day) {
			sum += days[day];
			if (sum == target) break;
		}
		return day;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int F1 = Integer.parseInt(st.nextToken());
		int F2 = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] days = new int[2001];

		while (C-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			if (start > D) continue;
			end = Math.min(end, D);

			for (int i = start; i <= end; ++i) {
				++days[i];
			}
		}

		// Solve & Output
		System.out.print(solve(days, (long) F1 - F2, D));
	}
}
