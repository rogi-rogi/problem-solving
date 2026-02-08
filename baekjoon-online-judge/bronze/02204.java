import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int N;
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			List<String[]> words = new ArrayList<>();
			for (int i = 0; i < N; ++i) {
				String word = br.readLine();

				// Solve
				words.add(new String[] {word.toLowerCase(), word});
			}
			words.sort((a, b) -> a[0].compareTo(b[0]));
			sb.append(words.get(0)[1]).append("\n");
		}

		// Output
		System.out.println(sb);
	}
}