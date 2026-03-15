import java.io.*;
import java.util.*;

public class Main {

	static class Person {
		int num, sum, time;

		Person(int num, int time) {
			this.num = num;
			this.time = time;
			this.sum = 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());

		// Solve
		int target = N - S;

		PriorityQueue<Person> pq = new PriorityQueue<>((a, b) -> {
			if (a.sum == b.sum) {
				return a.num - b.num;
			}
			return Integer.compare(a.sum, b.sum);
		});
		for (int i = 1; i <= M; ++i) {
			pq.add(new Person(i, Integer.parseInt(br.readLine())));
		}

		int lastPerson = 0;
		for (int i = 0; i < target; ++i) {
			Person p = pq.poll();
			lastPerson = p.num;
			p.sum += p.time;
			pq.add(p);
		}

		// Output
		System.out.print(lastPerson);
	}
}