import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] P = new int[2*N];
		for (int i = 0; i < 2*N; i += 2) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());

			// Solve
			P[i] = Integer.parseInt(st.nextToken());
			for (int j = 2; j < k; ++j) st.nextToken();
			P[i + 1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(P);

		// Output
		System.out.print(P[N - 1]);
	}
}
