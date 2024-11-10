import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        char[] S = br.readLine().toCharArray();

        // Solve
        for (int i = 0; i < S.length; ++i) {
            if ('A' <= S[i] && S[i] <= 'Z') {
                sb.append(S[i] - 'A' + 27);
            } else if ('a' <= S[i] && S[i] <= 'i') {
                sb.append('0').append(S[i] - 'a' + 1);
            } else if ('j' <= S[i] && S[i] <= 'z') {
                sb.append(S[i] - 'a' + 1);
            } else if ('0' <= S[i] && S[i] <= '9' ) {
                sb.append('#').append(S[i]);
            } else {
                sb.append(S[i]);
            }
        }

        // Output
        System.out.println(sb);
    }
}
