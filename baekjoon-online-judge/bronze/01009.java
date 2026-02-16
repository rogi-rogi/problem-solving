import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			// Solve
			int num = 1;
			while (B-- > 0) {
				num = (num*A) % 10;
			}
			sb.append(num == 0 ? 10 : num % 10).append('\n');
		}

		// Output
		System.out.println(sb);
	}
}
