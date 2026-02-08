import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		int max = 0;
		for (int a : A) {
			max = Math.max(max, a);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			if (A[i] == max) {
				sb.append((char) ('A' + i));
			}
		}

		// Output
		System.out.println(sb);
	}
}