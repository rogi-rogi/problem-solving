import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		int[][] rowPrefix = new int[N][M + 1];
		int[][] colPrefix = new int[N + 1][M];

		for (int r = 0; r < N; ++r) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; ++c) {
				int v = Integer.parseInt(st.nextToken());

				// Solve
				rowPrefix[r][c + 1] = rowPrefix[r][c] + v;
				colPrefix[r + 1][c] = colPrefix[r][c] + v;
			}
		}

		long count = 0;
		int len = 2 * K + 1;

		for (int r = K; r < N - K; ++r) {
			for (int c = K; c < M - K; ++c) {
				int rowSum = rowPrefix[r][c + K + 1] - rowPrefix[r][c - K];
				if (rowSum != len) continue;

				int colSum = colPrefix[r + K + 1][c] - colPrefix[r - K][c];
				if (colSum != len) continue;

				++count;
			}
		}

		// Output
		System.out.println(count);
	}
}
