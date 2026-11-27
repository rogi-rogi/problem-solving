import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// Solve
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int m = 0; m < M; ++m) {
			pq.add(0);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			int t = Integer.parseInt(st.nextToken());
			int cur = pq.poll();
			pq.add(cur + t);
		}

		// Output
		System.out.print(pq.peek() <= K ? "WAIT" : "GO");
	}
}