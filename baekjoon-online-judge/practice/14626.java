import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		char[] isbn = br.readLine().toCharArray();

		// Solve
		int[] W = {1, 3};
		int tmp = 0;
		int idx = -1;
		for (int i = 0; i <= 12; ++i) {
			if (isbn[i] != '*') {
				tmp += (isbn[i] - '0') * W[i % 2];
			} else {
				idx = i;
			}
		}
		for (int i = 0; i <= 9; ++i) {
			if ((tmp + i * W[idx % 2]) % 10 == 0) {

				// Output
				System.out.println(i);
				break;
			}
		}
	}
}