import java.io.*;
import java.util.*;

public class Main {
	static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

	private static void append(int S) {
		treeMap.put(S, treeMap.getOrDefault(S, 0) + 1);
	}

	private static void remove(int S) {
		Integer val = treeMap.get(S);
		if (val == null) return;
		if (val == 1)
			treeMap.remove(S);
		else
			treeMap.put(S, val - 1);
	}

	private static int calcPage() {
		if (treeMap.isEmpty()) return 0;

		int page = 1;
		Integer cur = treeMap.firstKey();

		while (true) {
			long limit = 2L * cur - 1;
			Integer next = treeMap.higherKey((int)Math.min(limit, Integer.MAX_VALUE));
			if (next == null) break;
			++page;
			cur = next;
		}
		return page;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// Input
		int Q = Integer.parseInt(br.readLine()), S;
		StringBuilder sb = new StringBuilder();
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			switch (Integer.parseInt(st.nextToken())) {
				case 1:
					append(Integer.parseInt(st.nextToken()));
					break;
				case 2:
					remove(Integer.parseInt(st.nextToken()));
					break;
				default: // case 3:
					sb.append(calcPage()).append('\n');
			}
		}

		// Output
		System.out.print(sb);
	}
}
