import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		// Solve
		Set<String> unique = new HashSet<>();
		TreeMap<String, Integer> cnt = new TreeMap<>();
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken() + " " + st.nextToken();
			String course = st.nextToken();

			String key = name + "|" + course;
			if (!unique.contains(key)) {
				unique.add(key);
				cnt.put(course, cnt.getOrDefault(course, 0) + 1);
			}
		}

		// Output
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
			sb.append(entry.getKey()).append(" ").append(entry.getValue()).append('\n');
		}
		System.out.print(sb);
	}
}
