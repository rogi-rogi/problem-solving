import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int A = Integer.parseInt(br.readLine());
		final int B = Integer.parseInt(br.readLine());
		final int C = Integer.parseInt(br.readLine());

		// Solve & Output
		System.out.println(A * B + C);
	}
}