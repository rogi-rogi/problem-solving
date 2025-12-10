import java.io.*;
import java.util.*;

public class Main {
	private static String reverse(int N) {
		return N == 0 ? "SciComLove" : "evoLmoCicS";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());

		// Solve & Output
		System.out.println(reverse(N % 2));
	}
}