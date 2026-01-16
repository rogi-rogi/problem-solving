import java.io.*;
import java.util.*;


public class Main {
	static Map<Integer, String> encode;
	static Map<String, Integer> decode;
	private static String solve(String A, String B) {
		return encode.get(decode.get(A) + decode.get(B));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		encode = new HashMap<>();
		encode.put(0, "{}");
		decode = new HashMap<>();
		decode.put("{}", 0);

		for (int i = 1; i <= 15; ++i) {
			StringBuilder encodeStr = new StringBuilder();
			encodeStr.append('{');
			for (int j = 0; j <= i - 1; ++j) {
				encodeStr.append(encode.get(j));
				if (j != i - 1) {
					encodeStr.append(',');
				}
			}
			encodeStr.append('}');
			encode.put(i, encodeStr.toString());
			decode.put(encodeStr.toString(), i);
		}

		// Input
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String A = br.readLine();
			String B = br.readLine();

			// Solve
			sb.append(solve(A, B)).append('\n');
		}

		// Output
		System.out.println(sb);
	}
}
