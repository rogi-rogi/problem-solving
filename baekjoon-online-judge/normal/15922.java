import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());

		// Solve
		int prevX = (int) -1e9;
		int prevY = (int) -1e9;
		int sum = 0;
		while (N-- > 0) {
			String[] input = br.readLine().split(" ");
			final int x = Integer.parseInt(input[0]);
			final int y = Integer.parseInt(input[1]);

			if (x <= prevY) {
				prevY = Math.max(y, prevY);
			} else {
				sum += Math.abs(prevY - prevX);
				prevX = x;
				prevY = y;
			}
		}
		sum += (Math.abs(prevY - prevX));

		// Output
		System.out.println(sum);
	}
}