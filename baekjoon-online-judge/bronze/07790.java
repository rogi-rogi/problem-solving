import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int result = 0;
		String S;
		while ((S = br.readLine()) != null) {

			// Solve
			result += (int) Pattern.compile("joke")
				.matcher(S)
				.results()
				.count();
		}

		// Output
		System.out.println(result);
	}
}