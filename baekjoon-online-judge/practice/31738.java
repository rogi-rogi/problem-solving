import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] input = br.readLine().split(" ");
		final long N = Long.parseLong(input[0]);
		final int M = Integer.parseInt(input[1]);

		// Solve
		long res = 1;
		if (N >= M) {
			res = 0;
		} else {
			for (long i = 2; i <= N; ++i) {
				res = (res * i % M) % M;
			}
		}

		// Output
		System.out.println(res);
	}
}