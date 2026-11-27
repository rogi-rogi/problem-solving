import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int D = Integer.parseInt(in[1]);

		// Solve
		StringBuilder sb = new StringBuilder();
		int k = 1;
		if (N % 2 == 0) {
			while (k <= N / 2) {
				sb.append(D + k).append(" ").append(D - k).append(" ");
				++k;
			}
		} else {
			sb.append(D).append(" ");
			while (k <= (N - 1) / 2) {
				sb.append(D + k).append(" ").append(D - k).append(" ");
				++k;
			}
		}

		// Output
		System.out.println(sb);
	}
}
