import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Solve
		int[] fibo = new int[46];
		fibo[0] = 1;
		fibo[1] = 1;
		for (int i = 2; i <= 45; ++i) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}

		// Input
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			sb.append(fibo[Integer.parseInt(br.readLine())]).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}
