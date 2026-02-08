import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] S = br.readLine().split(" ");
		final int K = Integer.parseInt(S[0]);
		final int L = Integer.parseInt(S[1]);

		// Solve
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < L; ++i) {
			map.put(br.readLine(), i);
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((a, b) -> a.getValue().compareTo(b.getValue()));


		// Output
		StringBuilder sb = new StringBuilder();
		final int SIZE = Math.min(K, list.size());
		for (int i = 0; i < SIZE; ++i) {
			sb.append(list.get(i).getKey()).append("\n");
		}
		System.out.println(sb);
	}
}