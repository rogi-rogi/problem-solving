import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		final int N = Integer.parseInt(in[0]);
		final int K = Integer.parseInt(in[1]);
		int[] A = new int[N];
		for  (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(br.readLine());
		}

		// Solve
		Arrays.sort(A);
		long sum = 0;
		for (int i = 0; i < N && A[i] < 0; i += K) {
			sum += (-A[i]);
		}
		for (int i = N - 1; i >= 0 && A[i] > 0; i -= K) {
			sum += A[i];
		}

		// Output
		System.out.println(sum * 2);
	}
}