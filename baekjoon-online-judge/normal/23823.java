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
		int[] rows = new int[N + 1], cols = new int[N + 1];
		int rowCount = 0, colCount = 0;
		int maxRow = 0, maxCol = 0;

		while (Q-- > 0) {
			in = br.readLine().split(" ");
			int t =  Integer.parseInt(in[0]);
			int a =  Integer.parseInt(in[1]);

			// Solve
			if (t == 1) {
				++rows[a];
				if (rows[a] == maxRow) {
					++rowCount;
				} else if (rows[a] > maxRow) {
					rowCount = 1;
				}
				maxRow = Math.max(maxRow, rows[a]);
			} else {
				++cols[a];
				if (cols[a] == maxCol) {
					++colCount;
				} else if (cols[a] > maxCol) {
					colCount = 1;
				}
				maxCol = Math.max(maxCol, cols[a]);
			}

			int result;
			if (rowCount == 0 || colCount == 0) {
				result = Math.max(rowCount, colCount) * N;
			} else {
				result = rowCount * colCount;
			}

			// Output
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}