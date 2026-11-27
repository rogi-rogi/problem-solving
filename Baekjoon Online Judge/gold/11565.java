import java.io.*;
import java.util.*;


public class Main {
	private static boolean solve(char[] A, char[] B) {
		int cntA = 0,  cntB = 0;
		for (char c : A) {
			if (c == '1')
				++cntA;
		}
		for (char c : B) {
			if (c == '1')
				++cntB;
		}

		if (cntA % 2 == 0) {
			return cntA >= cntB;
		}
		return cntA + 1 >= cntB;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();

		// Solve & Output
		System.out.println(solve(A, B) ? "VICTORY" : "DEFEAT");
	}
}
