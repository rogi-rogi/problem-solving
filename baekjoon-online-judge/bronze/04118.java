import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N;
		StringBuilder sb = new StringBuilder();
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			int[] count = new int[50];
			for (int i = 0; i < N; ++i) {
				for (int num : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {

					// Solve
					++count[num];
				}
			}

			boolean flag = true;
			for (int i = 1; i <= 49; ++i) {
				if (count[i] == 0) {
					flag = false;
					break;
				}
			}
			sb.append(flag ? "Yes" : "No").append("\n");
		}

		// Output
		System.out.println(sb);
	}
}