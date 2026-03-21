import java.io.*;
import java.util.*;

public class Main {

	static class Person {
		String name;
		int date;

		Person(String name, int d, int m, int y) {
			this.name = name;
			this.date = y * 10000 + m * 100 + d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		int N = Integer.parseInt(br.readLine());
		List<Person> list = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int d = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Person(name, d, m, y));
		}

		// Solve
		Collections.sort(list, (a, b) -> a.date - b.date);


		// Output
		System.out.println(list.get(N - 1).name);
		System.out.println(list.get(0).name);
	}
}