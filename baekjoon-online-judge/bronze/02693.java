import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			// Solve
			Arrays.sort(A);

			sb.append(A[7]).append("\n");
		}

		// Output
		System.out.println(sb);
	}
}