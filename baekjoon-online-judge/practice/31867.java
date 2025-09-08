import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		br.readLine();
		char[] K = br.readLine().toCharArray();

		// Solve
		int oddCnt = 0;
		for (char c : K) {
			if (c % 2 == 1)  {
				++oddCnt;
			} else {
				--oddCnt;
			}
		}

		// Output
		System.out.println(oddCnt == 0 ? -1 : (oddCnt > 0 ? 1 : 0));
	}
}