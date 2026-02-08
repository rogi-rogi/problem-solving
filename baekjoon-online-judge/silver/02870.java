import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		long N = Long.parseLong(br.readLine());
		List<BigInteger> result = new ArrayList<>();
		while (N-- > 0) {
			char[] A = br.readLine().toCharArray();
			StringBuilder num = new StringBuilder();

			// Solve
			for (int i = 0; i < A.length; ++i) {
				char c = A[i];

				if (Character.isDigit(c)) {
					num.append(c);
				} else {
					if (num.length() > 0) {
						result.add(new BigInteger(num.toString()));
						num.setLength(0);
					}
				}
			}

			if (num.length() > 0) {
				result.add(new BigInteger(num.toString()));
			}
		}
		result.sort(null);

		// Output
		StringBuilder sb = new StringBuilder();
		for (BigInteger i : result) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}