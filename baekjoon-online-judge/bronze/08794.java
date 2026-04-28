import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int Z = Integer.parseInt(br.readLine());

		while (Z-- > 0) {
			String[] in =  br.readLine().split(" ");
			int N =  Integer.parseInt(in[0]);
			int M =  Integer.parseInt(in[1]);
			int L =  Integer.parseInt(in[2]);

			if (L > 1) N -= M - L + 1;

			if (N % M == 0) sb.append(N / M).append('\n');
			else sb.append(N / M + 1).append('\n');
		}

		// Solve

		// Output
		System.out.println(sb);
	}
}