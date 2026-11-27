import java.io.*;
import java.util.*;

public class Main {
	private static int solve(String[] S) {
		char first = S[0].charAt(0);
		for (int i = 1; i < S.length; ++i) {
			if (S[i].charAt(0) != first) {
				return 0;
			}
		}
		return 1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.readLine();
		System.out.println(solve(br.readLine().split(" ")));
	}
}