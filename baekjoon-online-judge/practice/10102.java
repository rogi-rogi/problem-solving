import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();
        System.out.println(br.readLine().length());
        // Solve
        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            cnt = cnt + (S[i] == 'A' ? 1 : -1);
        }

        // Output
        String res = "Tie";
        if (cnt > 0) {
            res = "A";
        } else if (cnt < 0) {
            res = "B";
        }
        System.out.println(res);
    }
}
