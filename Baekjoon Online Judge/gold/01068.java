import java.io.*;
import java.util.*;

public class Main {
	final static int REMOVE = -2;
	static int[] parents;
	private static void dfs(int remove) {
		parents[remove] = REMOVE;
		for (int i = 0; i < parents.length; ++i) {
			if (parents[i] == remove) {
				dfs(i);
			}
		}
	}

	private static boolean isParent(int child) {
		for (int parent: parents) {
			if (parent == child) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		final int N = Integer.parseInt(br.readLine());
		parents = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		final int remove = Integer.parseInt(br.readLine());
		dfs(remove);

		int result = 0;
		for (int child = 0; child < N; ++child) {
			if (parents[child] != REMOVE && !isParent(child)) {
				++result;
			}
		}

		// Output
		System.out.println(result);
	}
}