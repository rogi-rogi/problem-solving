import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		final int N = Integer.parseInt(in[0]);
		final int M = Integer.parseInt(in[1]);

		// Solve
		String result = in[0].repeat(N);
		if (result.length() > M) {
			result = ori.substring(0, M);
		}
		/*
		final int len = in[0].length();
		final int oriLen = in[0].length() * N;
		if (oriLen > M) {
			final int repeatNeed = (M + len) / len;
			result = in[0].repeat(repeatNeed).substring(0, M);
		} else {
			result = in[0].repeat(N);
		}
		 */

		// Output
		System.out.println(result);
	}
}