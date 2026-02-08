import java.io.*;

public class Main {
    static char[] smallant;
    static char firstLighter;
    static long res = 0;

    private static int judge(char lighter, char smallant) {
        if (lighter == smallant) return 0;
        if ((lighter == 'R' && smallant == 'S') ||
                (lighter == 'S' && smallant == 'P') ||
                (lighter == 'P' && smallant == 'R')) {
            return 1;
        }
        return 2;
    }
    private static void bt(int idx, boolean isValid, char lastLighter, int lastWinner) {
        if (idx == smallant.length) {
            if (isValid) {
                ++res;
            }
            return;
        }
        // combinations : C(N, 1) ~ C(N, N)
        bt(idx + 1, isValid, lastLighter, lastWinner);

        final int curWinner = judge(isValid ? lastLighter : firstLighter, smallant[idx]);
        if (!(lastWinner == 1 && curWinner == 0)) {
            bt(idx + 1, true, smallant[idx], curWinner);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        firstLighter = br.readLine().charAt(0);
        smallant = br.readLine().toCharArray();

        // Solve
        bt(0, false, '\0', -1);

        // Output
        System.out.println(res % ((int) 1e9 + 7));
    }
}