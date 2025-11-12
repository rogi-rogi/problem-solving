import java.io.*;
import java.util.*;

public class Main {
	static int A, B;

	private static int recursive(int num) {
		if (num > B) {
			return 0;
		}
		if (num >= A) {
			return 1;
		}
		return recursive(num * 10 + 4) + recursive(num * 10 + 7);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		A = Integer.parseInt(in[0]);
		B = Integer.parseInt(in[1]);

		// Solve & Output
		System.out.println(recursive(4) + recursive(7));
	}
}