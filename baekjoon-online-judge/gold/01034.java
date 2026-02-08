import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		final int N =  Integer.parseInt(in[0]);
		final int M =  Integer.parseInt(in[1]);

		char[][] board = new char[N][M];
		String[] boardStr = new String[N];
		for (int i = 0; i < N; i++) {
			boardStr[i] = br.readLine();
			board[i] = boardStr[i].toCharArray();
		}

		final int K = Integer.parseInt(br.readLine());

		// Solve
		int result = 0;
		for (int row1 = 0; row1 < N; ++row1) {
			int zeroCnt = 0;
			for (int j = 0; j < M; ++j) {
				if (board[row1][j] == '0') {
					++zeroCnt;
				}
			}

			int max = 0;
			if (zeroCnt <= K && zeroCnt % 2 == K % 2) {
				for (int row2 = 0; row2 < N; ++row2) {
					if (boardStr[row1].equals(boardStr[row2])) {
						++max;
					}
				}
			}
			result = Math.max(result, max);
		}

		// Output
		System.out.println(result);
	}
}