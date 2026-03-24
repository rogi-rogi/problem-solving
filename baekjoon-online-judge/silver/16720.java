import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());

		// Solve
		int[] cnt = new int[4];
		for (int i = 0; i < N - 2; ++i) {
			String in = br.readLine();
			cnt[in.indexOf('0')]++;
		}

		int result = 3 + N - 1;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 4; ++i) {
			int move = 0;
			for (int j = 0; j < 4; ++j) {
				int d = Math.abs(j - i);
				move += Math.min(d, 4 - d) * cnt[j];
			}
			min = Math.min(min, move);
		}

		// Output
		System.out.print(result + min);
	}
}