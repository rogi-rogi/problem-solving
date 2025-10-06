import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());
		long[][] board = new long[N][N];
		long sum = 0;
		for (int i = 0; i < N; ++i) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			for (long num : board[i]) {
				sum += num;
			}
		}

		// Solve
		long resultOfJongjinMaxScore = Long.MAX_VALUE;
		for (int minwooRowMask = 0; minwooRowMask < (1 << N); ++minwooRowMask) {
			long jongjinMaxScore = Long.MIN_VALUE;
			for (int jongjinColMask = 0; jongjinColMask < (1 << N); ++jongjinColMask) {
				long jongjinScore = 0;
				for (int row = 0; row < N; ++row) {
					for (int col = 0; col < N; ++col) {
						final boolean minwoo = (minwooRowMask & (1 << row)) != 0;
						final boolean jongjin = (jongjinColMask & (1 << col)) != 0;
						if (minwoo == jongjin) {
							jongjinScore += board[row][col];
						}
					}
				}
				jongjinMaxScore = Math.max(jongjinMaxScore, jongjinScore);
			}
			resultOfJongjinMaxScore = Math.min(resultOfJongjinMaxScore, jongjinMaxScore);
		}

		// Output
		System.out.println(sum - resultOfJongjinMaxScore);
	}
}