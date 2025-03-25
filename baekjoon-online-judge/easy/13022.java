import java.io.*;

public class Main {
    public static boolean check(String word) {
        String[] patterns = new String[13];
        for (int i = 1; i <= 12; i++) {
            StringBuilder sb = new StringBuilder(4 * i);
            for (int j = 0; j < i; j++) {
                sb.append('w');
            }
            for (int j = 0; j < i; j++) {
                sb.append('o');
            }
            for (int j = 0; j < i; j++) {
                sb.append('l');
            }
            for (int j = 0; j < i; j++) {
                sb.append('f');
            }
            patterns[i] = sb.toString();
        }

        int idx = 0;
        int n = word.length();
        while (idx < n) {
            boolean matched = false;
            for (int i = 1; i <= 12; i++) {
                int patLen = 4 * i;
                if (idx + patLen > n) break;
                if (word.startsWith(patterns[i], idx)) {
                    idx += patLen;
                    matched = true;
                    break;
                }
            }
            if (!matched) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        String S = br.readLine();

        // Solve & Output
        System.out.println(check(S) ? 1 : 0);
    }
}