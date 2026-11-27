import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());

		long sum = 0;
		long prev = Long.parseLong(br.readLine());
		while (N-- > 1) {
			// Solve
			long cur = Long.parseLong(br.readLine());
			long mul = (cur - prev) * (cur - prev);
			sum += mul;
			prev = cur;
		}

		// Output
		System.out.print(sum);
	}
}
