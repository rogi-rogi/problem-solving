import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		final int n1 = Integer.parseInt(in[0]);
		final int n2 = Integer.parseInt(in[1]);

		/*
		S(n1, n2)는 Fermat Number의 집합이며, 서로 다른 두 Fermat Number는 항상 서로소이므로,
		R(n1, n2)은 1부터 (n2 - n1)까지의 합이 된다.
		 */

		// Solve & Output
		System.out.println((n2 - n1) * (n2 - n1 + 1) / 2);
	}
}