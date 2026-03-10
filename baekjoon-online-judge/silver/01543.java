import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String doc = br.readLine();
		String word = br.readLine();

		// Solve
		int cnt = 0;
		while (doc.contains(word)){
			doc = doc.substring(doc.indexOf(word) + word.length());
			++cnt;
		}

		// Output
		System.out.print(cnt);

	}
}