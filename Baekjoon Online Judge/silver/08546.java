import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int M = Integer.parseInt(in[1]);

		// Solve
		long[] fibo = new long[M + 1];
		fibo[1] = 1;
		fibo[2] = 1;
		for (int i = 3; i <= M; ++i) {
			fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 10;
		}
		for (int i = N; i <= M; ++i) {
			sb.append(fibo[i]);
		}

		// Output
		System.out.print(sb);
	}
}
