import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());
		int[] X = new int[N];
		int[] A = new int[N];

		int start = (int) 1e9, end = -start;
		for (int i = 0; i < N; ++i) {
			String[] in = br.readLine().split(" ");
			X[i] = Integer.parseInt(in[0]);
			A[i] = Integer.parseInt(in[1]);

			start = Math.min(start, X[i]);
			end =  Math.max(end, X[i]);
		}

		// Solve
		while (start <= end) {
			int mid = (start + end) >> 1;

			long diff = 0;
			for (int i = 0; i < N; ++i) {
				diff += (X[i] <= mid) ? A[i] : -A[i];
			}

			if (diff >= 0) end = mid - 1;
			else start = mid + 1;

		}

		// Output
		System.out.println(start);
	}
}