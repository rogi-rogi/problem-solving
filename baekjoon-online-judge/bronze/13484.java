import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		// Solve
		int result = X * (N + 1);
		while (N-- > 0) {
			result -= Integer.parseInt(br.readLine());
		}

		// Output
		System.out.println(result);
	}
}
