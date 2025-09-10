import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int sum = 0;
		for (int i = 0; i < 4; ++i) {
			sum += Integer.parseInt(br.readLine());
		}

		// Solve & Output
		System.out.println(sum <= 1500 ? "Yes" : "No");
	}
}