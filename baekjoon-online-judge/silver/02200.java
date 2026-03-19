import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// Solve
		st.nextToken();
		int cnt = 2 * N - 1;

		for (int i = N - 1; i >= 0; --i) {
			int a = Integer.parseInt(st.nextToken());
			if (a == 0) continue;
			++cnt; // +
			if (i == 0) {
				cnt += String.valueOf(a).length();
			} else if (a == 1) {
				cnt += 1;
			} else {
				cnt += String.valueOf(a).length();
			}
		}
		++cnt; // =

		// Output
		System.out.print(cnt);
	}
}