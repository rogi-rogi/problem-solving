import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		final int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] in =  br.readLine().split(" ");
			final int P = Integer.parseInt(in[0]);
			final int Q = Integer.parseInt(in[1]);

			// Solve
			long res;
			if (P <= 2) {
				res = 1 % Q;
			} else {
				long a = 1 % Q;
				long b = 1 % Q;
				for (int i = 3; i <= P; ++i) {
					long c = (a + b) % Q;
					a = b;
					b = c;
				}
				res = b;
			}
			sb.append("Case #").append(t).append(": ").append(res).append("\n");
		}

		// Output
		System.out.println(sb);
	}
}