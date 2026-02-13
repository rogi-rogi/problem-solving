import java.io.*;
import java.util.*;

public class Main {

	static class FastScanner {
		private final InputStream in;
		private final byte[] buf = new byte[1 << 16];
		private int ptr = 0, len = 0;

		FastScanner(InputStream in) {
			this.in = in;
		}

		private int readByte() throws IOException {
			if (ptr >= len) {
				len = in.read(buf);
				ptr = 0;
				if (len <= 0) return -1;
			}
			return buf[ptr++];
		}

		byte[] next() throws IOException {
			int c;
			do {
				c = readByte();
				if (c == -1) return null;
			} while (c <= ' ');

			byte[] out = new byte[64];
			int sz = 0;
			while (c > ' ') {
				if (sz == out.length) out = Arrays.copyOf(out, out.length << 1);
				out[sz++] = (byte) c;
				c = readByte();
			}
			return Arrays.copyOf(out, sz);
		}
	}

	static int[] pi = new int[0];

	static class Root {
		byte[] str;
		int baseLen;
		int exp;

		Root(byte[] str, int baseLen, int exp) {
			this.str = str;
			this.baseLen = baseLen;
			this.exp = exp;
		}
	}

	static void ensurePiCapacity(int n) {
		if (pi.length < n) pi = new int[n];
	}

	static int gcd(int a, int b) {
		while (b != 0) {
			int t = a % b;
			a = b;
			b = t;
		}
		return a;
	}

	static Root primitiveRoot(byte[] a) {
		int n = a.length;
		ensurePiCapacity(n);

		pi[0] = 0;
		for (int i = 1, j = 0; i < n; i++) {
			while (j > 0 && a[i] != a[j]) j = pi[j - 1];
			if (a[i] == a[j]) pi[i] = ++j;
			else pi[i] = 0;
		}

		int p = n - pi[n - 1];
		int baseLen = (n % p == 0) ? p : n;
		int exp = n / baseLen;

		return new Root(a, baseLen, exp);
	}

	static boolean sameBase(Root r, Root s) {
		if (r.baseLen != s.baseLen) return false;
		for (int i = 0; i < r.baseLen; i++) {
			if (r.str[i] != s.str[i]) return false;
		}
		return true;
	}

	static boolean isHash(byte[] t) {
		return t.length == 1 && t[0] == (byte) '#';
	}

	public static void main(String[] args) throws Exception {
		FastScanner fs = new FastScanner(System.in);
		StringBuilder sb = new StringBuilder();

		// Input
		while (true) {
			byte[] rTok = fs.next();
			byte[] sTok = fs.next();
			if (rTok == null || sTok == null) break;
			if (isHash(rTok) && isHash(sTok)) break;

			// Solve
			Root r = primitiveRoot(rTok);
			Root s = primitiveRoot(sTok);

			if (!sameBase(r, s)) {
				sb.append("NAO\n");
				continue;
			}

			int a = r.exp;
			int b = s.exp;
			int g = gcd(a, b);

			int m = b / g;
			int n = a / g;

			sb.append(m).append(' ').append(n).append('\n');
		}

		// Output
		System.out.print(sb);
	}
}
