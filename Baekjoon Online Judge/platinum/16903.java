import java.io.*;
import java.util.*;

public class Main {

	static final int MAX_BIT = 30;
	static Node root = new Node();

	static class Node {
		Node[] child = new Node[2];
		int count;
	}

	static void insert(int x) {
		Node cur = root;
		++cur.count;

		for (int bit = MAX_BIT; bit >= 0; --bit) {
			int b = (x >> bit) & 1;
			if (cur.child[b] == null) {
				cur.child[b] = new Node();
			}
			cur = cur.child[b];
			++cur.count;
		}
	}

	static void remove(int x) {
		Node cur = root;
		--cur.count;

		for (int bit = MAX_BIT; bit >= 0; --bit) {
			int b = (x >> bit) & 1;
			cur = cur.child[b];
			--cur.count;
		}
	}

	static int getMaxXor(int x) {
		Node cur = root;
		int result = 0;

		for (int bit = MAX_BIT; bit >= 0; --bit) {
			int b = (x >> bit) & 1;
			int next = 1 - b;

			if (cur.child[next] != null && cur.child[next].count > 0) {
				result |= (1 << bit);
				cur = cur.child[next];
			} else {
				cur = cur.child[b];
			}
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int M = Integer.parseInt(br.readLine());

		// Solve
		insert(0);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			if (type == 1) {
				insert(x);
			} else if (type == 2) {
				remove(x);
			} else {
				sb.append(getMaxXor(x)).append('\n');
			}
		}

		// Output
		System.out.print(sb);
	}
}