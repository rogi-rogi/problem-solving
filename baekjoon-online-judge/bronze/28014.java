import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		int result = 1;
		for (int i = 0; i < N - 1; ++i) {
			if (A[i] <= A[i + 1]) ++result;
		}

		// Output
		System.out.print(result);

	}
}