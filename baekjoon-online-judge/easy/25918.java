import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		br.readLine();
		char[] S = br.readLine().toCharArray();

		// Solve
		List<Character> stack = new ArrayList<>();
		int cnt = 0;
		for (char ch : S) {
			if (stack.isEmpty() || stack.get(stack.size() - 1) == ch) {
				stack.add(ch);
				cnt = Math.max(cnt, stack.size());
			} else {
				stack.remove(stack.size() - 1);
			}
		}

		// Output
		System.out.println(stack.isEmpty() ? cnt : -1);
	}
}