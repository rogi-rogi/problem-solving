import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        // Solve
        int moreSecurity = 0;
        for (int i = 0; i < S.length; ++i) {
            if (S[i] == 's') {
                ++moreSecurity;
            } else if (S[i] == 'b') {
                --moreSecurity;
            }
        }

        // Output
        String res = "bigdata? security!";
        if (moreSecurity > 0) {
            res = "security!";
        } else if (moreSecurity < 0) {
            res = "bigdata?";
        }
        System.out.println(res);
    }
}