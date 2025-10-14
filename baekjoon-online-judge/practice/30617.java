import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// Input
		int T = Integer.parseInt(br.readLine());
		int prevL, prevR, curL, curR;
		st = new StringTokenizer(br.readLine());
		prevL = Integer.parseInt(st.nextToken());
		prevR = Integer.parseInt(st.nextToken());

		// Solve
		int cnt = (prevL != 0 && prevL == prevR) ? 1 : 0;
		while (--T > 0) {
			st = new StringTokenizer(br.readLine());
			curL = Integer.parseInt(st.nextToken());
			curR = Integer.parseInt(st.nextToken());

			if (curL != 0 && curL == prevL) {
				++cnt;
			}
			if (curR != 0 && curR == prevR) {
				++cnt;
			}
			if (curL != 0 && curL == curR) {
				++cnt;
			}
			prevL = curL;
			prevR = curR;
		}

		// Output
		System.out.println(cnt);
	}
}