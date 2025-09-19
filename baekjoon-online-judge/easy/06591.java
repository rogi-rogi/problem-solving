import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			final int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			if (N == 0 && K == 0) {
				break;
			}

			if (K > N / 2) {
				K = N - K;
			}

			long result = 1;
			for (int i = 0; i < K; i++) {
				result = result * (N - i) / (i + 1);
			}
			sb.append(result).append("\n");
		}

		// Output
		System.out.print(sb);
	}
}