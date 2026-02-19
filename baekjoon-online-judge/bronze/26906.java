import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int T = Integer.parseInt(br.readLine());
		Map<String, String> map = new HashMap<>();
		while (T-- > 0) {
			String[] in = br.readLine().split(" ");
			map.put(in[1], in[0]);
		}

		// Solve
		String N = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= N.length() - 4; i += 4) {
			sb.append(map.getOrDefault(N.substring(i, i + 4), "?"));
		}

		// Output
		System.out.print(sb);
	}
}
