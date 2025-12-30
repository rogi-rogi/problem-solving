import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			long[] state = new long[51];
			long union = 0L;

			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; ++i) {
				String[] in = br.readLine().split(" ");
				int K = Integer.parseInt(in[0]);

				long mask = 0L;
				for (int j = 1; j <= K; j++) {
					int x = Integer.parseInt(in[j]);
					long bit = 1L << (x - 1);
					mask |= bit;
					union |= bit;
				}
				state[i] = mask;
			}

			// Solve
			int ans = 0;
			int unionSize = Long.bitCount(union);

			for (int i = 0; i < 50; i++) {
				long xBit = 1L << i;
				long cmb = 0L;

				for (int j = 0; j < N; j++) {
					if ((xBit & state[j]) != 0L) continue;
					cmb |= state[j];
				}

				int cmbSize = Long.bitCount(cmb);
				if (cmbSize < unionSize) {
					ans = Math.max(ans, cmbSize);
				}
			}
			sb.append(ans).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}