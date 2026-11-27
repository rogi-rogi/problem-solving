import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int cnt = 0;
		for (int num : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
			// Solve
			if (num > 0) ++cnt;
		}

		// Output
		System.out.println(cnt);
	}
}