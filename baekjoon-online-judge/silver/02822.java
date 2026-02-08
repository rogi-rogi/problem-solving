import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		List<int[]> score = new ArrayList<>();
		for (int i = 1; i <= 8; ++i) {
			score.add(new int[] {i, Integer.parseInt(br.readLine())});
		}

		// Solve
		score.sort((a, b) -> Integer.compare(b[1], a[1]));

		int sum = 0;
		int[] idxList = new int[5];
		for (int i = 0; i < 5; ++i) {
			sum += score.get(i)[1];
			idxList[i] = score.get(i)[0];
		}
		Arrays.sort(idxList);

		// Output
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append("\n");
		for (int idx: idxList) {
			sb.append(idx).append(" ");
		}
		System.out.println(sb);
	}
}