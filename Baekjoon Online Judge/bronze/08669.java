import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// Input
		int T = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();

			// Solve
			set.add(st.nextToken());
		}

		// Output
		System.out.print(set.size());
	}
}
