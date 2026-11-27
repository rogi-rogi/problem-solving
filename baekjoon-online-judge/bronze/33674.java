import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] input = br.readLine().split(" ");
		final int D = Integer.parseInt(input[1]);
		final int K = Integer.parseInt(input[2]);
		int[] S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		int maxDay = Integer.MAX_VALUE;
		for (int s : S) {
			maxDay = Math.min(maxDay, K / s);
		}
		int clean = (D - 1) / maxDay;

		// Output
		System.out.println(clean);
	}
}