import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final String number = br.readLine();
        final int NUM = 10, ALPHA = 26;

        // Solve
        char prev = number.charAt(0), cur;
        int res = (prev == 'd' ? NUM : ALPHA);
        for (int i = 1; i < number.length(); ++i) {
            if ((cur = number.charAt(i)) == prev)
                res *= (cur == 'd' ? NUM - 1 : ALPHA - 1);
            else
                res *= (cur == 'd' ? NUM : ALPHA);
            prev = cur;
        }

        // Output
        System.out.println(res);
    }
}
