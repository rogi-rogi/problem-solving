import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // Input
        line = br.readLine();

        // Solve
        String res = "PPAP";
        char cur;
        int p = 0;
        final int SIZE = line.length();
        for (int i = 0; i < SIZE; ++i) {
            cur = line.charAt(i);
            if (cur == 'P') ++p;
            else if ((cur == 'A' && p >= 2) && (i < SIZE - 1 && line.charAt(i + 1) == 'P')) {
                ++i;
                --p;
            } else {
                res = "NP";
                break;
            }
        }
        if (p > 1) res = "NP";

        // Output
        System.out.println(res);
    }
}
