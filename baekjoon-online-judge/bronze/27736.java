import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		int inValid = 0, reject = 0;
		for (int a : A) {
			if (a == 0) {
				++inValid;
			} else if (a == -1) {
				++reject;
			}
		}
		String res = "APPROVED";
		if (inValid >= (N + 1) / 2) {
			res = "INVALID";
		} else if (reject >= N - inValid - reject) {
			res = "REJECTED";
		}

		// Output
		System.out.println(res);
	}
}