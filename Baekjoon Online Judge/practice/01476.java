import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        int E = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);

        // Solve
        final int MAX_E = 15, MAX_S = 28, MAX_M = 19;
        int e = 1, s = 1, m = 1;
        int cnt = 1;
        while (e != E || s != S || m != M) {
            ++cnt;
            e = e % MAX_E + 1;
            s = s % MAX_S + 1;
            m = m % MAX_M + 1;
        }

        // Output
        System.out.println(cnt);
    }
}
