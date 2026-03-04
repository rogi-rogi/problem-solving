import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		long N = Long.parseLong(br.readLine());

		// Solve
		long num = 1, sum = 0;
		while (N > 0) {
			if((N & 1) == 1) {
				sum += num;
			}
			num *= 3;
			N >>= 1;
		}

		// Output
		System.out.print(sum);
	}
}