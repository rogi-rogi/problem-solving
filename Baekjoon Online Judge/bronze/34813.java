import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		char firstChar = br.readLine().charAt(0);

		// Solve
		String result;
		switch (firstChar) {
			case 'F':
				result = "Foundation";
				break;
			case 'C':
				result = "Claves";
				break;
			case 'V':
				result = "Veritas";
				break;
			default: // case 'E':
				result = "Exploration";
				break;

		}

		// Output
		System.out.println(result);
	}
}