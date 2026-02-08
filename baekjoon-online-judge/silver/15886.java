import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        br.readLine();
        char[] S = br.readLine().toCharArray();

        // Solve
        int cnt = 0;
        for (int i = 1; i < S.length; ++i) {
            if (S[i - 1] == 'E' && S[i] == 'W') {
                ++cnt;
            }
        }

        // Output
        System.out.println(cnt);
    }
}