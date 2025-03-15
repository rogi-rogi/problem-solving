import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        char[] S = br.readLine().toCharArray();

        // Solve
        int cnt = 1;
        for (int i = 1; i < S.length; ++i) {
            if (S[i] <= S[i - 1]) {
                ++cnt;
            }
        }

        // Output
        System.out.println(cnt);
    }
}