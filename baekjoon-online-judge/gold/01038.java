import java.io.*;
import java.util.*;

public class Main {
	static List<Long> list;
	private static void bt(long num, int len) {
		if (len == 11)
			return;
		list.add(num);
		for (int i = 0; i < num % 10; ++i) {
			bt((num * 10) + i, len + 1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());

		// Solve
		if (N <= 10) {
			System.out.println(N);
		} else if (N > 1022) {
			System.out.println(-1);
		} else {
			list = new ArrayList<>();
			for (int i = 0; i < 10; ++i) {
				bt(i, 1);
			}
			Collections.sort(list);

			// Output
			System.out.println(list.get(N));
		}
	}
}