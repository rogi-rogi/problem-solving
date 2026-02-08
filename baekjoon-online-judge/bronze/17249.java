import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input & Solve
		String[] S = br.readLine().split("0");

		int l = 0, r = 0;
		for (int i = 0; i < S[0].length(); ++i) {
			if (S[0].charAt(i) == '@') {
				++l;
			}
		}
		for (int i = 0; i < S[1].length(); ++i) {
			if (S[1].charAt(i) == '@') {
				++r;
			}
		}

		// Output
		System.out.println(l + " " + r);
	}
}