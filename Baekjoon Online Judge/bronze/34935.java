import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		long[] A = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

		// Solve
		int result = 1;
		long prev = A[0];
		for (int i = 1; i < N; ++i) {
			if (A[i] <= prev) {
				result = 0;
				break;
			}
			prev = A[i];
		}

		// Output
		System.out.print(result);
	}
}