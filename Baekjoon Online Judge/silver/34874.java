import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int M = Integer.parseInt(in[1]);

		// Solve
		int[] cnt = new int[M];
		while (N-- > 0) {
			int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int max = 0;
			for (int i = 0; i < M; ++i) {
				if (A[i] > max) {
					max = A[i];
				}
			}
			for (int i = 0; i < M; ++i) {
				if (A[i] != max) {
					++cnt[i];
				}
			}
		}

		// Output
		for (int i = 0; i < M; ++i) {
			sb.append(cnt[i]).append(" ");
		}
		System.out.println(sb);
	}
}