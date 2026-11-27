import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		int[][] A = new int[N][N];
		for (int i = 0; i < N; ++i) {
			A[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// Solve
		int[][] B = new int[N][N];
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				for (int k = 0; k < N; ++k) {
					B[r][c] += A[r][k] * A[k][c];
				}
			}
		}

		long result = 0;
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				if (r == c) continue;
				result += (long)B[r][c] * (B[r][c] - 1);
			}
		}

		// output
		System.out.println(result);
	}
}
