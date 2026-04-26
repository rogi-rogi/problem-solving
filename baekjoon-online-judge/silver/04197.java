import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// Input
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			double x = 0, y = 0, d = 0;
			while (N-- > 0) {
				String[] cmd = br.readLine().split(" ");

				// Solve
				final double val = Double.parseDouble(cmd[1]);
				switch (cmd[0]) {
					case "fd":
						x += val * Math.cos(Math.toRadians(d));
						y += val * Math.sin(Math.toRadians(d));
						break;
					case "bk":
						// 뒤로 이동
						x -= val * Math.cos(Math.toRadians(d));
						y -= val * Math.sin(Math.toRadians(d));
						break;
					case "lt":
						// 왼쪽으로 회전
						d += val;
						break;
					case "rt":
						// 오른쪽으로 회전
						d -= val;
						break;
				}
			}
			sb.append(Math.round(Math.sqrt(x * x + y * y))).append('\n');

		}

		// Output
		System.out.println(sb);
	}
}