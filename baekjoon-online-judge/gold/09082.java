import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			char[] numStr = br.readLine().toCharArray();
			int[] num = new int[N];
			for (int i = 0; i < N; ++i) {
				num[i] = numStr[i] - '0';
			}

			br.readLine();

			// Solve
			int result = 0;

			for (int i = 0; i < N; ++i) {
				if (i == 0) {
					if (N >= 2 && num[0] != 0 && num[1] != 0) {
						--num[0];
						--num[1];
						++result;
					}
				} else if (i == N - 1) {
					if (num[i] != 0 && num[i - 1] != 0) {
						--num[i];
						--num[i - 1];
						++result;
					}
				} else {
					if (num[i - 1] != 0 && num[i] != 0 && num[i + 1] != 0) {
						--num[i - 1];
						--num[i];
						--num[i + 1];
						++result;
					}
				}
			}

			sb.append(result).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}
