import java.io.*;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		// Init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] line;

		// Input
		line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int[] nums = IntStream.rangeClosed(1, N).toArray();
		for (int i = 0; i < N; ++i) nums[i] = i + 1;

		// Solve
		while (M-- > 0) {
			line = br.readLine().split(" ");
			int i = Integer.parseInt(line[0]) - 1;
			int j = Integer.parseInt(line[1]) - 1;

			// swap
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}

		// Output
		for (int num : nums) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
}
