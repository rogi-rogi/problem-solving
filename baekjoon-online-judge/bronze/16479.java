import java.io.*;
import java.util.*;

public class Main {

	private static double solve(double D1, double D2, double C) {
		if (D1 == D2) {
			return C * C;
		}
		double A = Math.abs((D1 / 2) - (D2 / 2));
		return Math.pow(C, 2) - Math.pow(A, 2); // is B^2
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		double K = Double.parseDouble(br.readLine());
		String[] in = br.readLine().split(" ");
		double D1 = Double.parseDouble(in[0]);
		double D2 = Double.parseDouble(in[1]);

		// Solve & Output
		System.out.print(solve(D1, D2, K));
	}
}