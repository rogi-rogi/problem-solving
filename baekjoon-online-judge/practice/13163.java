import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			// Solve
			String[] in =  br.readLine().split(" ", 2);
			sb.append("god").append(in[1].replace(" ", "")).append("\n");
		}

		// Output
		System.out.println(sb);
	}
}