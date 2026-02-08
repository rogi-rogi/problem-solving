import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		String regex = "^[A-F]?A+F+C+[A-F]?$";
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			// Solve
			sb.append(br.readLine().matches(regex) ? "Infected!\n" : "Good\n");
		}

		// Output
		System.out.println(sb);
	}
}