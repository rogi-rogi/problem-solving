import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		int A = Integer.parseInt(in[0]);
		int B = Integer.parseInt(in[1]);

		// Solve & Output
		System.out.print(A ^ B);
	}
}