import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		final int N = Integer.parseInt(in[0]);
		final int M = Integer.parseInt(in[1]);

		// Solve
		String ori = in[0].repeat(N);
		if (ori.length() > M) {
			ori = ori.substring(0, M);
		}

		// Output
		System.out.println(ori);
	}
}