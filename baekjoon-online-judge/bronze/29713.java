import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		String in = br.readLine();

		// Solve
		int[] alpha = new int[26];
		for (int i = 0; i < N; ++i) {
			++alpha[in.charAt(i) - 'A'];
		}
		int result = Math.min(alpha['E' - 'A'] / 2, alpha['R' - 'A'] / 2);
		char[] temp = {'B', 'O', 'N', 'Z', 'S', 'I', 'L', 'V'};
		for (char c : temp) {
			result = Math.min(result, alpha[c - 'A']);
		}

		// Output
		System.out.print(result);
	}
}