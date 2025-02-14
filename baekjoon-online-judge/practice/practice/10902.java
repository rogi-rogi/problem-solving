import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve
        int Sf = 0, P = 0;
        for (int f = 1; f <= N; ++f) {
            st = new StringTokenizer(br.readLine());
            final int t = Integer.parseInt(st.nextToken());
            final int s = Integer.parseInt(st.nextToken());
            if (s > Sf) {
                Sf = s;
                P = t + (f - 1) * 20;
            }
        }

        // Output
        System.out.println(P);
    }
}