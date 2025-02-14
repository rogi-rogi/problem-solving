import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        String input = br.readLine();

        // Solve
        final int N = input.length();
        char c;
        int ascii;
        for (int i = 0; i < N; ++i) {
            c = input.charAt(i);
            if (!Character.isLetter(c)) sb.append(c);
            else {
                ascii = c + 13;
                if (Character.isUpperCase(c) && ascii > 90)
                    ascii -= 26;
                if (Character.isLowerCase(c) && ascii > 122)
                    ascii -= 26;
                sb.append((char)ascii);
            }
        }

        // Output
        System.out.println(sb);
    }
}
