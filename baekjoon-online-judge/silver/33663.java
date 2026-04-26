import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// Input
		st = new StringTokenizer(br.readLine());
		final int hLow = Integer.parseInt(st.nextToken());
		final int hHigh = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		final int sLow = Integer.parseInt(st.nextToken());
		final int sHigh = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		final int vLow = Integer.parseInt(st.nextToken());
		final int vHigh = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		final int R = Integer.parseInt(st.nextToken());
		final int G = Integer.parseInt(st.nextToken());
		final int B = Integer.parseInt(st.nextToken());
		final int M = Math.max(R, Math.max(G, B));
		final int m = Math.min(R, Math.min(G, B));

		// Solve
		final Double V = (double) M;
		final Double S = 255 * (V - m) / V;
		Double H = 0.0;
		if (V == R) {
			H = 60 * (G - B) / (V - m);
		} else if (V == G) {
			H = 120 + 60 * (B - R) / (V - m);
		} else if (V == B) {
			H = 240 + (60 * (R - G)) / (V - m);
		}
		H = (H + 360) % 360;
		boolean res = (hLow <= H && H <= hHigh && sLow <= S && S <= sHigh && vLow <= V && V <= vHigh);

		// Output
		System.out.println(res ? "Lumi will like it." : "Lumi will not like it.");
	}
}