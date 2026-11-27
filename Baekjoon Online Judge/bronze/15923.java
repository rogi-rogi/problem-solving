import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		int[] x = new int[N];
		int[] y = new int[N];

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		// Solve
		long result = 0;
		for (int i = 0; i < N; ++i) {
			int j = (i + 1) % N;
			result += Math.abs(x[j] - x[i]) + Math.abs(y[j] - y[i]);
		}

		// Output
		System.out.print(result);
	}
}