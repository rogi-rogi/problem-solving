import java.io.*;
import java.util.*;

public class Main {

	static final int TARGET = 20;

	private static int[][] transpose(int[][] A, int N, int M) {
		int[][] B = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				B[j][i] = A[i][j];
			}
		}
		return B;
	}

	private static long solve(int[][] A, int N, int M) {
		long result = 0;
		int[] freq = new int[TARGET];

		for (int r1 = 0; r1 < N - 1; ++r1) {
			for (int r2 = r1 + 1; r2 < N; ++r2) {

				Arrays.fill(freq, 0);

				for (int c = 0; c < M; c++) {
					int sum = A[r1][c] + A[r2][c];
					++freq[sum];
				}

				for (int t = 2; t <= 9; t++) {
					result += (long) freq[t] * freq[TARGET - t];
				}

				long f10 = freq[10];
				result += f10 * (f10 - 1) / 2;
			}
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// Solve
		if (N > M) {
			A = transpose(A, N, M);
			int tmp = N;
			N = M;
			M = tmp;
		}

		// Output
		System.out.print(solve(A, N, M));
	}
}