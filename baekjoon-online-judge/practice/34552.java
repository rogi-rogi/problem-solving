import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		int res = 0;
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			String[] in = br.readLine().split(" ");

			int b = Integer.parseInt(in[0]);
			double l = Double.parseDouble(in[1]);
			int s = Integer.parseInt(in[2]);

			if (s >= 17 && l >= 2.0) {
				res += A[b];
			}
		}

		// Output
		System.out.println(res);
	}
}