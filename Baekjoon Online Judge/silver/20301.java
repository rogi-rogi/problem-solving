import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");

		int N = Integer.parseInt(in[0]);
		int K = Integer.parseInt(in[1]);
		int M = Integer.parseInt(in[2]);

		// Solve
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= N; ++i) {
			dq.addLast(i);
		}
		StringBuilder sb = new StringBuilder();
		boolean clockwise = true;
		int removedCount = 0;

		while (!dq.isEmpty()) {
			int removed;

			if (clockwise) {
				for (int i = 0; i < K - 1; ++i) {
					dq.addLast(dq.pollFirst());
				}
				removed = dq.pollFirst();
			} else {
				for (int i = 0; i < K - 1; ++i) {
					dq.addFirst(dq.pollLast());
				}
				removed = dq.pollLast();
			}

			sb.append(removed).append('\n');
			++removedCount;

			if (removedCount % M == 0) {
				clockwise = !clockwise;
			}
		}

		// Output
		System.out.print(sb);
	}
}