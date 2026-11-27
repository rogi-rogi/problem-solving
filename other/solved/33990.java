import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		int res = 1234;
		while (N-- > 0) {

			// Solve
			final int sum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
			if (sum >= 512) {
				res = Math.min(res, sum);
			}
		}

		// Output
		System.out.println(res == 1234 ? -1 : res);
	}
}