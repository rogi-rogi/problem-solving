import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] cnt = new long[3];
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());

			// Solve
			if (A[i] <= 1) {
				++cnt[A[i]];
			} else {
				++cnt[2];
			}
		}

		long result = (cnt[0] * (cnt[0] - 1) / 2)   // mex = 1 : (0,0)
			+ (cnt[0] * cnt[2])                 // mex = 1 : (0,x)
			+ (2L * cnt[0] * cnt[1]);           // mex = 2 : (0,1)

		// Output
		System.out.print(result);
	}
}
