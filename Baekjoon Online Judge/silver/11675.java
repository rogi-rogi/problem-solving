import java.io.*;
import java.util.*;

public class Main {

	static int decode(int b) {
		int x = b;
		x ^= x << 1;
		x ^= x << 2;
		x ^= x << 4;
		return x & 255;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// Solve
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			sb.append(decode(Integer.parseInt(st.nextToken()))).append(" ");
		}

		// Output
		System.out.print(sb);
	}
}