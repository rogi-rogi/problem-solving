import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long K;
	static List<Integer> path = new ArrayList<>();
	static long cnt = 0;
	static boolean found = false;
	static StringBuilder sb;

	static void dfs(int sum) {
		if (found) return;

		if (sum == N) {
			++cnt;

			if (cnt == K) {
				sb = new StringBuilder();
				for (int i = 0; i < path.size(); i++) {
					if (i > 0) sb.append("+");
					sb.append(path.get(i));
				}
			}
			return;
		}

		if (sum > N) return;

		for (int x = 1; x <= 3; ++x) {
			path.add(x);
			dfs(sum + x);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());

		// Solve
		dfs(0);

		// Output
		System.out.println(sb != null ? sb : -1);
	}
}
