import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());
		int[][] villages = new int[N][2];

		long total = 0;
		for (int i = 0; i < N; ++i) {
			villages[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			total += villages[i][1];
		}

		// Solve
		Arrays.sort(villages, (a, b) -> {
			return Integer.compare(a[0], b[0]);
		});

		final long HALF = (total + 1) >> 1;
		long sum = 0;
		for (int[] village: villages) {
			sum += village[1];
			if (sum >= HALF) {

				// Output
				System.out.println(village[0]);
				return;
			}
		}
	}
}