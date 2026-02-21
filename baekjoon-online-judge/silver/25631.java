import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Solve
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int a : A) {
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		}
		int result = 0;
		for (int key : map.keySet()) {
			result = Math.max(result, map.get(key));
		}

		// Output
		System.out.print(result);
	}
}