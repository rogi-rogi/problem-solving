import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		int[] rank = new int[N];
		for (int i = 0; i < N; ++i) {
			rank[i] = Integer.parseInt(br.readLine());
		}

		// Solve
		Arrays.sort(rank);

		long result = 0;
		for (int i = 0; i < N; ++i) {
			if (rank[i] != i + 1) {
				result += Math.abs(rank[i] - (i + 1));
			}
		}

		// Output
		System.out.println(result);
	}
}