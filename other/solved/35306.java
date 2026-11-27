import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int K = Integer.parseInt(in[1]);
		int[][] scores = new int[N][K];
		for (int i = 0; i < N; ++i) {
			scores[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// Solve
		boolean[] candidate = new boolean[N];
		for (int j = 0; j < K; ++j) {
			int maxVal = -1;
			int maxIdx = -1;
			int count = 0;

			for (int i = 0; i < N; ++i) {
				int v = scores[i][j];

				if (v > maxVal) {
					maxVal = v;
					maxIdx = i;
					count = 1;
				} else if (v == maxVal) {
					++count;
				}
			}
			if (count == 1) {
				candidate[maxIdx] = true;
			}
		}
		int ans = 0;
		for (boolean c : candidate) {
			if (c) ++ans;
		}
		sb.append(ans);

		// Output
		System.out.print(sb);
	}
}