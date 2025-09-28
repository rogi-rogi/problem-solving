import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());

		// Solve & Output
		System.out.println(8 + (31 - Integer.numberOfLeadingZeros(N)) + 2);
	}
}