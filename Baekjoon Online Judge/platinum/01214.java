import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		long D = Long.parseLong(in[0]);
		long P = Long.parseLong(in[1]);
		long Q = Long.parseLong(in[2]);

		// Solve
		long max = Math.max(P, Q);
		long min = Math.min(P, Q);
		P = max; Q = min;

		long k = Math.min((int) 1e9, (P - (D % P)) % P);
		long N = Math.min(D / P, Q);
		for (int x = 0; x <= N; ++x) {
			k = Math.min(k, (Q - (D - P*x) % Q) % Q);
		}

		// Output
		System.out.print(D + k);
	}
}