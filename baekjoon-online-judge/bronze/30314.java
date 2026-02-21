import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		String A = br.readLine();
		String B = br.readLine();

		// Solve
		int result = 0;
		for (int i = 0; i < N; ++i) {
			int dist = Math.abs(B.charAt(i) - A.charAt(i));
			result += Math.min(dist, 26 - dist);
		}

		// Output
		System.out.print(result);
	}
}