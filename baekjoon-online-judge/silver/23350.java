import java.io.*;
import java.util.*;

public class Main {
	static class Box {
		int p, w;
		Box(int p, int w) {
			this.p = p;
			this.w = w;
		}
	}

	static int res = 0;

	private static int move(Deque<Integer> stack, int curW) {
		if (stack.isEmpty()) {
			stack.push(curW);
			return curW;
		}
		Deque<Integer> tmp = new ArrayDeque<>();
		int move = 0;
		while (!stack.isEmpty() && curW > stack.peek()) {
			final int moveWeight = stack.pop();
			move += 2 * moveWeight;
			tmp.push(moveWeight);
		}
		stack.push(curW);
		while (!tmp.isEmpty()) {
			stack.push(tmp.pop());
		}

		return move + curW;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());

		int[] priorityCount = new int[M + 1];
		Deque<Box> queue = new ArrayDeque<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			Box box = new Box(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			// Solve
			++priorityCount[box.p];
			queue.add(box);
		}

		int highestPriority = M;
		Map<Integer, Deque<Integer>> stack = new HashMap<>();
		for (int i = 1; i <= M; ++i) {
			stack.put(i, new ArrayDeque<>());
		}
		while (!queue.isEmpty()) {
			while (priorityCount[highestPriority] > 0) {
				Box cur = queue.poll();

				if (cur.p < highestPriority) {
					res += cur.w;
					queue.add(cur);
					continue;
				}
				res += move(stack.get(highestPriority), cur.w);
				--priorityCount[highestPriority];
			}
			--highestPriority;
		}

		// Output
		System.out.println(res);
	}
}