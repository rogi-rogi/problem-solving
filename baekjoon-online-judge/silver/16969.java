import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        char[] board = br.readLine().toCharArray();
        final int MOD = (int) (1e9 + 9);

        // Solve
        char prev = '\0';
        long cnt = 1;
        for (char c : board) {
            if (c != prev) {
                cnt = (cnt * (c == 'd' ? 10 : 26)) % MOD;
            } else {
                cnt = (cnt * (c == 'd' ? 9 : 25)) % MOD;
            }
            prev = c;
        }

        // Output
        System.out.print(cnt);
    }
}