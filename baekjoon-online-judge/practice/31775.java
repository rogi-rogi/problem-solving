import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int result = 0;
		for (int i = 0; i < 3; ++i) {

			// Solve
			switch (br.readLine().charAt(0)) {
				case 'l':
					result ^= 1;
					break;
				case 'k':
					result ^= 2;
					break;
				case 'p':
					result ^= 4;
					break;
			}
		}

		// Output
		System.out.println(result == 7 ? "GLOBAL" : "PONIX") ;
	}
}