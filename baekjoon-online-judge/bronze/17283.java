import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int L = Integer.parseInt(br.readLine());
		int R = Integer.parseInt(br.readLine());

		// Solve
		int result = 0;
		int cnt = 1;
		while ((L = L * R / 100) > 5) {
			result += (cnt <<= 1) * L;
		}

		// Output
		System.out.println(result);
	}
}