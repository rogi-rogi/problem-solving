import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		Arrays.sort(A);

		int sum = A[N - 1] - A[0];
		for (int i = 1; i < N; ++i) {
			sum += A[i] - A[i - 1];
		}

		// Output
		System.out.println(sum);
	}
}