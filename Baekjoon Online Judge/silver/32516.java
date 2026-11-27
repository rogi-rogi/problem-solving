import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        // Solve
        final int HALF = N >> 1;
        int cnt = 0;
        for (int i = 0; i < HALF; ++i) {
            if (S[i] == '?' && S[N - i - 1] == '?') {
                cnt += 26;
            } else if (S[i] == '?' || S[N - i - 1] == '?') {
                ++cnt;
            } else if (S[i] != S[N - i - 1]) {
                cnt = 0;
                break;
            }
        }

        // Output
        System.out.println(cnt);
    }
}