import java.io.*;
import java.util.*;

public class Main {
	static long ceilDiv(long numerator, long denominator) {
		return (numerator + denominator - 1) / denominator;
	}

	private static String solve(
		int heroHp, int heroATK,
		long devilHp, int devilATK,
		int P, int S
	) {
		long requiredHitsWithoutHeal = ceilDiv(devilHp, heroATK);

		long devilHpBeforeFinalHit = devilHp - (requiredHitsWithoutHeal - 1) * heroATK;

		long totalHeroHits;
		if (devilHpBeforeFinalHit <= P && S > 0) {
			long devilHpAfterHeal = devilHpBeforeFinalHit + S;
			long extraHitsAfterHeal = ceilDiv(devilHpAfterHeal, heroATK);
			totalHeroHits = (requiredHitsWithoutHeal - 1) + extraHitsAfterHeal;
		} else {
			totalHeroHits = requiredHitsWithoutHeal;
		}

		long devilCounterAttacks = totalHeroHits - 1;
		long totalDamageToHero = devilCounterAttacks * devilATK;

		return (totalDamageToHero < heroHp) ? "Victory!" : "gg";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in = br.readLine().split(" ");
		final int heroHp = Integer.parseInt(in[0]);
		final int heroATK = Integer.parseInt(in[1]);
		final int devilHp = Integer.parseInt(in[2]);
		final int devilATK = Integer.parseInt(in[3]);
		in = br.readLine().split(" ");
		final int P =  Integer.parseInt(in[0]);
		final int S =  Integer.parseInt(in[1]);

		// Solve & Output
		System.out.println(solve(heroHp, heroATK, devilHp, devilATK, P, S));
	}
}