import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		br.readLine();
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		int[] C = new int[A.length + B.length];
		for (int i = 0; i < A.length; ++i) {
			C[i] = A[i];
		}
		for (int i = 0; i < B.length; ++i) {
			C[A.length + i] = B[i];
		}
		Arrays.sort(C);

		// Output
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < C.length; ++i) {
			sb.append(C[i]).append(" ");
		}
		System.out.println(sb);
	}
}