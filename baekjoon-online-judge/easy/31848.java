import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		final int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		br.readLine();
		int[] S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


		// Solve
		int[] hole = new int[N];
		int max = 0;
		for (int i = 0; i < N; ++i) {
			max = Math.max(max, A[i] + i);
			hole[i] = max;
		}

		for (int s : S) {
			int left = 0, right = N - 1;
			while (left < right) {
				int mid = (left + right) / 2;
				if (hole[mid] < s) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			sb.append(right + 1).append(" ");
		}


		// Output
		System.out.println(sb);
	}
}