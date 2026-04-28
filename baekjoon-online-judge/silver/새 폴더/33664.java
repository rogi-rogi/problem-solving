import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// Input
		st = new StringTokenizer(br.readLine());
		final long B = Long.parseLong(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Math.min(280, Integer.parseInt(st.nextToken()));
		Map<String, Long> map = new HashMap<>();

		// Solve
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), Long.parseLong(st.nextToken()));
		}

		long sum = 0;
		while (M-- > 0) {
			sum += map.get(br.readLine());
			if (sum > B) {
				M = -999;
				break;
			}
		}

		// Output
		System.out.println(M == -999 ? "unacceptable" : "acceptable");
	}
}