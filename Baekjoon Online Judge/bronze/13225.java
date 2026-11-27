import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int C = Integer.parseInt(br.readLine());

		// Solve
		StringBuilder sb = new StringBuilder();
		while (C-- > 0) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> list = new ArrayList<>();
			for (int i = 1; i <= N; ++i) {
				if (N % i == 0) {
					list.add(i);
				}
			}
			sb.append(N).append(' ').append(list.size()).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}
