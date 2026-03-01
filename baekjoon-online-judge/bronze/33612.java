import java.io.*;
import java.util.*;

public class Main {

	private static String solve(int N) {
		if (N == 1) {
			return "2024 8";
		} else if (N == 2) {
			return "2025 3";
		} else if (N == 3) {
			return "2025 10";
		} else if (N == 4) {
			return "2026 5";
		}
		return "2026 12";
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());

		// Solve & Output
		System.out.print(solve(N));
	}
}
