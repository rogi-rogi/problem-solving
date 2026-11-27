import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		char[] A = in[0].toCharArray();
		char[] B = in[1].toCharArray();

		// Solve
		int min = Integer.MAX_VALUE;

		for (int start = 0; start <= B.length - A.length; start++) {
			int cnt = 0;
			for (int i = 0; i < A.length; i++) {
				if (A[i] != B[start + i]) ++cnt;
			}
			min = Math.min(min, cnt);
		}

		// Output
		System.out.println(min);
	}
}