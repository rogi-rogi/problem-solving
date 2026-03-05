import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// Solve
		int[] cnt = new int[N];
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			++cnt[Integer.parseInt(st.nextToken()) - 1];
		}
		Arrays.sort(cnt);

		long result = 0;
		for (int i = 1; i < N; ++i) {
			if (cnt[i - 1] >= cnt[i]) {
				result += (cnt[i - 1] - cnt[i] + 1);
				cnt[i] = cnt[i - 1] + 1;
			}
		}

		// Output
		System.out.print(result);
	}
}
