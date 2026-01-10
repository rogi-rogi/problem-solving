import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		String str = br.readLine();

		// solve
		String res = "z".repeat(50);
		final int SIZE = str.length();

		for (int e = 2; e < SIZE; ++e) {
			for (int s = 1; s < e; ++s) {
				StringBuilder newStr = new StringBuilder();
				newStr.append(new StringBuilder(str.substring(0, s)).reverse());
				newStr.append(new StringBuilder(str.substring(s, e)).reverse());
				newStr.append(new StringBuilder(str.substring(e)).reverse());

				if (newStr.toString().compareTo(res) < 0) {
					res = newStr.toString();
				}
			}
		}

		// output
		System.out.println(res);
	}
}
