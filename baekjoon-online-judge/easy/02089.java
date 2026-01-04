import java.io.*;
import java.util.*;

public class Main {
	private static String solve(int N) {
		if (N == 0) return "0";
		StringBuilder sb = new StringBuilder();
		while (N != 0) {
			int r = Math.floorMod(N, -2);
			sb.append(r > 0 ? '1' : '0');
			N = Math.floorDiv(N, -2) + (r > 0 ? 1 : 0);
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());

		// Solve & Output
		System.out.println(solve(N));
	}
}