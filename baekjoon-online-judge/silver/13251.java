import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int M = Integer.parseInt(br.readLine());
		int N = 0;
		int[] color = new int[M];
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; ++i){
			color[i] = Integer.parseInt(st.nextToken());
			N += color[i];
		}
		int K = Integer.parseInt(br.readLine());

		// Solve
		double result = 0;
		for (int c : color) {
			double temp = 1;
			for(int j = 0; j < K; ++j){
				temp *= (double) (c - j) / (N - j);
			}
			result += temp;
		}

		// Output
		System.out.print(result);
	}
}