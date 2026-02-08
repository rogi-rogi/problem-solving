import java.io.*;

public class Main {
    private static int[] getCnt(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        String A, B;
        while ((A = br.readLine()) != null && (B = br.readLine()) != null) {
            // Solve
            int[] cntA = getCnt(A);
            int[] cntB = getCnt(B);

            for (int i = 0; i < 26; ++i) {
                final int common = Math.min(cntA[i], cntB[i]);
                if (common > 0) {
                    sb.append(String.valueOf((char) ('a' + i)).repeat(common));
                }
            }
            sb.append("\n");
        }

        // Output
        System.out.println(sb);
    }
}