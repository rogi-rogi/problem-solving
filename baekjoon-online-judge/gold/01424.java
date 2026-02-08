import java.io.*;
import java.util.*;

public class Main {
	private static int solve(int N, int L, int C) {
		int maxSongCount = C / (L + 1);
		int cdFreeSpace = C % (L + 1);
		if (cdFreeSpace == L) {
			++maxSongCount;
		}

		maxSongCount = Math.min(N, maxSongCount);

		if (maxSongCount == N) {
			return maxSongCount % 13 == 0 ? 2 : 1;
		}

		if (maxSongCount % 13 == 0) {
			--maxSongCount;
		}

		int result = N / maxSongCount;
		int R = N % maxSongCount;

		if (R == 0) {
			return result;
		} else if (R % 13 != 0) {
			return result + 1;
		}
		return (result + 1) + (maxSongCount > R + 1 ? 0 : 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());
		final int L = Integer.parseInt(br.readLine());
		final int C = Integer.parseInt(br.readLine());

		// Solve & Output
		System.out.println(solve(N, L, C));
	}
}