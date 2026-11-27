import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());

		// Solve
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i <= N; ++i) {
			for (int v = 0; v <= N - i; ++v) {
				for (int x = 0; x <= N - i - v; ++x) {
					int l = N - i - v - x;

					int sum = i * 1 + v * 5 + x * 10 + l * 50;
					set.add(sum);
				}
			}
		}

		// Output
		System.out.println(set.size());
	}
}