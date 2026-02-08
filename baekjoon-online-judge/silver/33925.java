import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new  StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int J = Integer.parseInt(st.nextToken());
		final int S = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		final int K = Integer.parseInt(st.nextToken());

		char[][] board = new char[3][N];
		for (int i = 0; i < 3; ++i) {
			board[i] = br.readLine().toCharArray();
		}

		int needS = 0, needDoubleJ = 0, needJ = 0;
		for (char c : board[0]) {
			if (c == 'v')
				++needS;
		}
		for (int i = 0; i < N; ++i) {
			if (board[1][i] == '^') {
				++needDoubleJ;
			} else if (board[2][i] == '^') {
				++needJ;
			}
		}

		// Solve
		if (needS > S) {
			H -= (needS - S) * K;
		}
		if (needJ > J) {
			H -= (needDoubleJ + needJ - J) * K;
		} else if (2 * needDoubleJ > J - needJ) {
			final int remainingJumps = J - needJ;
			final int highJumpDeficit = 2 * needDoubleJ - remainingJumps;
			final int obstaclesToHit = (highJumpDeficit + 1) / 2;
			H -= obstaclesToHit * K;
		}

		// Output
		System.out.println(H <= 0 ? -1 : H);
	}
}