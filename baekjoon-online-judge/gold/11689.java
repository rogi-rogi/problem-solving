import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		long N = Long.parseLong(br.readLine());

		// Solve
		long euler = N;
		long MAX = (long) Math.sqrt(N);
		for (long p = 2; p <= MAX; ++p) {
			if (N % p == 0)
				euler = euler / p * (p - 1);
			while (N % p == 0) {
				N = N / p;
			}
		}

		// Output
		System.out.print(N == 1 ? euler : euler / N * (N - 1));
	}
}