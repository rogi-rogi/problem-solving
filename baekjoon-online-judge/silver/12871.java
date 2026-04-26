import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String S = br.readLine();
		String T = br.readLine();

		// Solve & Output
		System.out.print(S.repeat(T.length()).equals(T.repeat(S.length())) ? 1 : 0);

	}
}