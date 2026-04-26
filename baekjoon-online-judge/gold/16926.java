import java.io.*;
import java.util.*;

public class Main {
	static int N, M, R;
	static int[][] A;

	static void rotate() {
		int layers = Math.min(N, M) / 2;

		for (int layer = 0; layer < layers; ++layer) {
			List<Integer> list = new ArrayList<>();

			int sx = layer, sy = layer;
			int ex = N - 1 - layer, ey = M - 1 - layer;

			for (int j = sy; j <= ey; ++j) list.add(A[sx][j]);
			for (int i = sx + 1; i <= ex - 1; ++i) list.add(A[i][ey]);
			for (int j = ey; j >= sy; --j) list.add(A[ex][j]);
			for (int i = ex - 1; i >= sx + 1; --i) list.add(A[i][sy]);

			int len = list.size();
			int move = R % len;
			List<Integer> rotated = new ArrayList<>();
			rotated.addAll(list.subList(move, len));
			rotated.addAll(list.subList(0, move));

			int idx = 0;
			for (int j = sy; j <= ey; ++j) A[sx][j] = rotated.get(idx++);
			for (int i = sx + 1; i <= ex - 1; ++i) A[i][ey] = rotated.get(idx++);
			for (int j = ey; j >= sy; --j) A[ex][j] = rotated.get(idx++);
			for (int i = ex - 1; i >= sx + 1; --i) A[i][sy] = rotated.get(idx++);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		for (int i = 0; i < N; ++i) {
			A[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// Solve
		rotate();

		// Output
		StringBuilder sb = new StringBuilder();
		for (int[] row : A) {
			for (int x : row) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}