import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		String[] in = br.readLine().split(" ");
		int R = Integer.parseInt(in[0]);
		int C = Integer.parseInt(in[1]);
		int V = Integer.parseInt(in[2]);
		int H = Integer.parseInt(in[3]);
		char[][] board = new char[R][C];

		// Solve
		char curChar = 'B';
		int prev = 0;
		while (V-- > 0) {
			int next = Integer.parseInt(br.readLine());
			for (int i = prev; i < prev + next; ++i) {
				Arrays.fill(board[i], curChar);
			}
			prev += next;
			curChar = (curChar == 'B') ? 'W' : 'B';
		}

		prev = 0;
		curChar = 'B';
		while (H-- > 0) {
			int next = Integer.parseInt(br.readLine());
			for (int j = prev; j < prev + next; ++j) {
				for (int i = 0; i < R; ++i)
					board[i][j] = (board[i][j] == curChar) ? 'B' : 'W';
			}
			prev += next;
			curChar = (curChar == 'B') ? 'W' : 'B';
		}

		// Output
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				sb.append(board[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}