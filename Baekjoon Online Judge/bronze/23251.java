import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			// Solve
			sb.append(Integer.parseInt(br.readLine()) * 23).append("\n");
		}

		// Output
		System.out.println(sb);
	}
}