import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		final int N = Integer.parseInt(in[0]);
		final int M = Integer.parseInt(in[1]);

		int[][] board = new int[101][101];
		for (int i = 0; i < N; ++i) {
			in = br.readLine().split(" ");
			final int x1 = Integer.parseInt(in[0]);
			final int y1 = Integer.parseInt(in[1]);
			final int x2 = Integer.parseInt(in[2]);
			final int y2 = Integer.parseInt(in[3]);

			// Solve
			for (int x = x1; x <= x2; ++x) {
				for (int y = y1; y <= y2; ++y) {
					++board[x][y];
				}
			}
		}

		int cnt = 0;
		for (int x = 1; x <= 100; ++x) {
			for (int y = 1; y <= 100; ++y) {
				if (board[x][y] > M) {
					++cnt;
				}
			}
		}

		// Output
		System.out.println(cnt);
	}
}