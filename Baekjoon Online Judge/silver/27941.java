import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// Input
		int[] res = new int[11];

		// Solve
		int line = 2047;
		while (line-- > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 11; ++i) {
				final int num = Integer.parseInt(st.nextToken());
				res[i] ^= num;
			}
		}

		// Output
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 11; ++i) {
			sb.append(res[i]).append(" ");
		}
		System.out.println(sb);
	}
}