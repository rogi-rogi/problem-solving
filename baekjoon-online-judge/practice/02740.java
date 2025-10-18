import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		final int N = Integer.parseInt(in[0]);
		final int M = Integer.parseInt(in[1]);
		int[][] A = new int[N][M];
		for (int i = 0; i < N; ++i) {
			A[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		in = br.readLine().split(" ");
		final int K = Integer.parseInt(in[1]);
		int[][] B = new int[M][K];
		for (int i = 0; i < M; ++i) {
			B[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// Solve
		int[][] C = new int[N][K];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < K; ++j) {
				for (int k = 0; k < M; ++k) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}


		// Output
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			for (int c : C[i]) {
				sb.append(c).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}