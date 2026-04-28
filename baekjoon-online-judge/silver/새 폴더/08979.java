import java.io.*;
import java.util.*;

public class Main {
	static class Country implements Comparable<Country> {
		int no;
		int gold, silver, bronze;

		Country(int no, int gold, int silver, int bronze) {
			this.no = no;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public int compareTo(Country o) {
			if (this.gold != o.gold) return o.gold - this.gold;
			if (this.silver != o.silver) return o.silver - this.silver;
			return o.bronze - this.bronze;
		}

		boolean sameMedal(Country o) {
			return this.gold == o.gold &&
				this.silver == o.silver &&
				this.bronze == o.bronze;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Country> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Country(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
			));
		}

		// Solve
		Collections.sort(list);
		int rank = 1;
		for (int i = 0; i < N; ++i) {
			if (i > 0 && !list.get(i).sameMedal(list.get(i - 1))) {
				rank = i + 1;
			}

			if (list.get(i).no == K) {
				// Output
				System.out.println(rank);
				return;
			}
		}
	}
}