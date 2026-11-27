import java.io.*;
import java.util.*;

public class Main {
    static final int BIT_COUNT = 17, MAX = 1 << BIT_COUNT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        boolean[] covering = new boolean[MAX];
        while (N-- > 0) {
            String club = br.readLine();
            int mask = 0;
            for (int i = 0; i < club.length(); ++i) {
                mask |= 1 << (club.charAt(i) - 'a');
            }
            covering[mask] = true;
        }
        for (int i = 0; i < BIT_COUNT; ++i) {
            for (int mask = 0; mask < MAX; ++mask) {
                if ((mask & (1 << i)) != 0) {
                    covering[mask] |= covering[mask ^ (1 << i)];
                }
            }
        }

        char[] schedule = br.readLine().toCharArray();
        int[] cnt = new int[BIT_COUNT];
        int mask = 0;
        int l = 0, r = 0;
        long result = 0;
        while (r < schedule.length) {
            int x = schedule[r] - 'a';
            if (cnt[x]++ == 0) mask |= 1 << x;

            while (l <= r) {
                int y = schedule[l] - 'a';
                int newMask = mask;
                if (cnt[y] == 1) newMask &= ~(1 << y);

                if (!covering[newMask]) {
                    break;
                }
                --cnt[y];
                mask = newMask;
                ++l;
            }
            if (covering[mask]) result += l + 1;
            ++r;
        }

        // Output
        System.out.println(result);
    }
}
