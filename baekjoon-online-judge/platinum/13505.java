import java.io.*;
import java.util.*;

public class Main {

	static final int MAX_BIT = 30;

	static class Node {
		Node[] child = new Node[2];
		int count;
	}

	static Node root = new Node();

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

	static int maxXor(int x) {
		Node cur = root;
		int result = 0;

		for (int bit = MAX_BIT; bit >= 0; --bit) {
			int b = (x >> bit) & 1;
			int opposite = 1 - b;

			if (cur.child[opposite] != null && cur.child[opposite].count > 0) {
				result |= (1 << bit);
				cur = cur.child[opposite];
			} else {
				cur = cur.child[b];
			}
		}
		return result;
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			// Solve
			insert(arr[i]);
		}

		int answer = 0;
		for (int i = 0; i < N; ++i) {
			remove(arr[i]);
			answer = Math.max(answer, maxXor(arr[i]));
			insert(arr[i]);
		}

		// Output
		System.out.print(answer);
	}
}