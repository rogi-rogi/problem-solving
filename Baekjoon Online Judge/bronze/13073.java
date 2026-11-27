import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			// Solve
			int sum = N*(N+1)/2;
			int evenSum = sum*2;
			int oddSum = evenSum - N;
			sb.append(sum).append(' ')
				.append(oddSum).append(' ')
				.append(evenSum).append('\n');
		}

		// Output
		System.out.println(sb);
	}
}
