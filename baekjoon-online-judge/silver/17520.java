import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());

		// Solve
		int MOD = 16769023;
		int exp = (N + 1) / 2;
		int result = 1;
		for (int i = 0; i < exp; i++) {
			result = (result * 2) % MOD;
		}

		// Output
		System.out.print(result);
	}
}