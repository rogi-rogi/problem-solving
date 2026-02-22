import java.io.*;
import java.util.*;

public class Main {

	static int N, M, cnt = 0;
	static int[] A;

	private static void dfs(int cur) {
		if (A[cur] == M) return;
		++cnt;
		dfs(A[cur]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		String[] in = br.readLine().split(" ");
		N = Integer.parseInt(in[0]);
		M = Integer.parseInt(in[1]);
		A = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// Solve
		dfs(M);

		// Output
		System.out.println(cnt == 0 ? 0 : cnt + 1);
	}
}
