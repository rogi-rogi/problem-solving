import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());
		char[] A = br.readLine().toCharArray();

		// Solve
		long result = 0;
		int cnt = A[0] == '1' ? 1 : 0;
		for (int i = 1; i < N; ++i) {
			if (A[i] == '1') {
				++cnt;
			} else {
				result += (long)cnt * (cnt + 1) / 2;
				cnt = 0;
			}
		}
		if (cnt > 0) {
			result += (long)cnt * (cnt + 1) / 2;
		}

		// Output
		System.out.println(result);
	}
}