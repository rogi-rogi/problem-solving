import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in =  br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int M = Integer.parseInt(in[1]);
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = B[i] - A[i]; // diff
			arr[i][1] = B[i];        // b
		}
		Arrays.sort(arr, (x, y) ->
			x[0] != y[0] ? Integer.compare(x[0], y[0]) : Integer.compare(x[1], y[1]));

		for (int i = 0; i < N; ++i) {
			if (M < arr[i][0]) {
				break;
			}
			M = M - arr[i][0] + arr[i][1];
		}

		// Output
		System.out.print(M);
	}
}
