import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			long N = Long.parseLong(br.readLine());

			// Solve
			long res = 0;
			long powerOf3 = 1;
			while (N > 0) {
				if ((N & 1) == 1) {
					res += powerOf3;
				}
				powerOf3 *= 3;
				N >>= 1;
			}
			sb.append(res).append("\n");
		}

		// Output
		System.out.println(sb);
	}
}