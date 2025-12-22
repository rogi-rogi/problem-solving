import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			long N = Long.parseLong(br.readLine());

			if (N == 0) {
				sb.append("0\n");
				continue;
			}

			// Solve
			StringBuilder num = new StringBuilder();
			while (N != 0) {
				long r = N % 3;
				N /= 3;

				if (r == 2) {
					r = -1;
					N += 1;
				}
				if (r == -2) {
					r = 1;
					N -= 1;
				}

				if (r == -1) num.append('-');
				else num.append(r);
			}

			sb.append(num.reverse()).append("\n");
		}

		// Output
		System.out.println(sb);
	}
}