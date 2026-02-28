import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		br.readLine();
		List<Integer> A = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> B = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		// Solve
		A.retainAll(B);
		Set<Integer> treeSet = new TreeSet<>(A);

		// Output
		StringBuilder sb = new StringBuilder();
		for (int num : treeSet) {
			sb.append(num).append('\n');
		}
		System.out.print(sb);
	}
}
