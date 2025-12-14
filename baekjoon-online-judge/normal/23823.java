import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int Q = Integer.parseInt(in[1]);
		int[] R = new int[N + 1], C = new int[N + 1];
		int maxRow = 0, maxCol = 0;
		int maxRowCount = N, maxColCount = N;

		while (Q-- > 0) {
			in = br.readLine().split(" ");
			int t = Integer.parseInt(in[0]);
			int a = Integer.parseInt(in[1]);

			// Solve
			if (t == 1) {
				++R[a];
				if (R[a] == maxRow) {
					++maxRowCount;
				} else if (R[a] > maxRow) {
					maxRowCount = 1;
					maxRow = R[a];
				}
			} else {
				++C[a];
				if (C[a] == maxCol) {
					++maxColCount;
				} else if (C[a] > maxCol) {
					maxColCount = 1;
					maxCol = C[a];
				}
			}

			// Output
			sb.append(maxRowCount * maxColCount).append("\n");
		}
		System.out.println(sb);
	}
}