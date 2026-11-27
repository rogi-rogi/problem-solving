import java.io.*;

public class Main {
    static String A;
    private static int recursive(String B) {
        if (A.equals(B)) return 1;
        if (A.length() == B.length()) return 0;
        if (B.charAt(B.length() - 1) == 'A') {
            if (recursive(B.substring(0, B.length() - 1)) == 1)
                return 1;
        }
        if (B.charAt(0) == 'B') {
            if (recursive((new StringBuilder(B.substring(1))).reverse().toString()) == 1)
                return 1;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        A = br.readLine();

        // Solve & Output
        System.out.println(recursive(br.readLine()));
    }
}
