import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());

		// Solve
		int right = 0;
		int cnt = 0, sum = 0;
		for (int left = 1; left <= N; ++left) {
			while (sum < N && right <= N) {
				sum += right;
				++right;
			}
			if (sum == N) {
				++cnt;
			}
			sum -= left;
		}

		// Output
		System.out.println(cnt);
	}
}