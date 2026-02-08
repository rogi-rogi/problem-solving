import java.io.*;

public class Main {
    private static String solve(char[] S) {
        int[] alpha = new int[26];

        for (int i = 0; i < S.length; ++i) {
            ++alpha[S[i] - 'A'];
            if (alpha[S[i] - 'A'] % 4 == 3) {
                if (i + 1 == S.length ||
                        (i + 1 < S.length && S[i] != S[i + 1])
                ) {
                    return "FAKE";
                }
            }
        }
        return "OK";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] S = br.readLine().toCharArray();
            // Solve
            sb.append(solve(S)).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}