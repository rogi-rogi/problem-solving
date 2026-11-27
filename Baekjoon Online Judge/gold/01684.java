import java.io.*;
import java.util.*;

class Main {

	private static int gcd(int x, int y) {
		while (y > 0) {
			int t = x % y;
			x = y;
			y = t;
		}
		return x;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		Arrays.sort(A);
		List<Integer> temp = new ArrayList<>();
		for (int i = 1; i < N; ++i)
			temp.add(A[i] - A[i - 1]);

		int result = temp.get(0);
		for (int i = 1; i < temp.size(); i++)
			result = gcd(result, temp.get(i));

		// Output
		System.out.print(result);
	}
}