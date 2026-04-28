import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder sb = new StringBuilder();

		while ((line = br.readLine()) != null && !line.isEmpty()) {
			final int M = Integer.parseInt(line);
			List<int[]> lines = new ArrayList<>();

			while (true) {
				String[] input = br.readLine().split(" ");
				int l = Integer.parseInt(input[0]);
				int r = Integer.parseInt(input[1]);
				if (l == 0 && r == 0) {
					break;
				}
				if (r > 0 && l < M) {
					lines.add(new int[]{l, r});
				}
			}


			// Solve
			lines.sort((a, b) -> {
				if (a[0] == b[0]) {
					return Integer.compare(a[1], b[1]);
				}
				return Integer.compare(a[0], b[0]);
			});

			int cnt = 0;
			int cur = 0;
			int idx = 0;
			boolean possible = true;

			while (cur < M) {
				int maxR = -1;
				while (idx < lines.size() && lines.get(idx)[0] <= cur) {
					maxR = Math.max(maxR, lines.get(idx)[1]);
					++idx;
				}
				if (maxR <= cur) {
					possible = false;
					break;
				}
				cur = maxR;
				++cnt;
			}
			sb.append(possible ? cnt : 0).append("\n");
		}

		// Output
		System.out.println(sb);
	}
}