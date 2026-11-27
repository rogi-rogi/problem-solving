import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> A = new ArrayList<>();
		A.add(0);
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			A.add(Integer.parseInt(st.nextToken()));
		}

		// Solve
		A.sort(null);
		List<Integer> diff = new ArrayList<>();
		for (int i = 1; i < A.size(); ++i) {
			diff.add(A.get(i) - A.get(i - 1));
		}
		diff.sort(null);
		long sum = 0;
		for (int i = 0; i < N - K; ++i) {
			sum += diff.get(i);
		}

		// Output
		System.out.print(sum);
	}
}
