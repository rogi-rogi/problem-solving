import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int K = Integer.parseInt(in[1]);

		// Solve
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int barber = (i % K) + 1;
			sb.append(barber).append(' ');
		}

		// Output
		System.out.print(sb);
	}
}