import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int score;
		int cnt;
		Node(int score, int cnt) {
			this.score = score;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		Node[][] board = new Node[N + 1][N + 1];
		for (int i = 0; i <= N; ++i) {
			board[i][0] = new Node(0, 0);
			board[0][i] = new Node(0, 0);
		}
		for (int i = 1; i <= N; ++i) {
			int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 1; j <= N; ++j) {
				board[i][j] = new Node(line[j - 1], 0);
			}
		}

		// Solve
		int P = Integer.parseInt(br.readLine());
		while (P-- > 0) {
			String[] in =  br.readLine().split(" ");
			int x = Integer.parseInt(in[0]);
			int y = Integer.parseInt(in[1]);
			++board[x][y].cnt;
		}

		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				Node up   = board[i - 1][j];
				Node left = board[i][j - 1];

				board[i][j].score += Math.max(up.score, left.score);

				if (up.score > left.score) {
					board[i][j].cnt += up.cnt;
				} else if (up.score < left.score) {
					board[i][j].cnt += left.cnt;
				} else {
					board[i][j].cnt += Math.max(up.cnt, left.cnt);
				}
			}
		}

		// Output
		System.out.println(board[N][N].score + " " + board[N][N].cnt);
	}
}