import java.io.*;

public class Main {
    static char[] ptn = "olf".toCharArray();

    private static boolean check(char[] S) {
        int idx = 0, gap = 0;
        while (idx < S.length) {
            if (S[idx] != 'w') {
                return false;
            }
            while (idx < S.length && S[idx] == 'w') {
                ++gap;
                ++idx;
            }
            for (char ch : ptn) {
                for (int g = 0; g < gap; ++g) {
                    if (idx >= S.length || S[idx] != ch) {
                        return false;
                    }
                    ++idx;
                }
            }
            gap = 0;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        char[] S = br.readLine().toCharArray();

        // Solve & Output
        System.out.println(check(S) ? 1 : 0);
    }
}