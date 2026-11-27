import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			// Solve
			Arrays.sort(A);
			sb.append(A[3] - A[1] >= 4 ?
				"KIN" : A[1] + A[2] + A[3]
			).append("\n");
		}

		// Output
		System.out.print(sb);
	}
}
