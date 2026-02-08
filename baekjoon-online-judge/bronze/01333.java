import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int L = Integer.parseInt(st.nextToken());
        final int D = Integer.parseInt(st.nextToken());

        // Solve
        boolean[] isMusicPlaying = new boolean[4000];
        for (int i = 0; i < N; ++i) {
            final int start = i * (L + 5);
            final int end = start + L;
            for (int t = start; t < end; ++t) {
                isMusicPlaying[t] = true;
            }
        }

        for (int t  = 0; ; t += D) {
            if (!isMusicPlaying[t]) {
                // Output
                System.out.println(t);
                break;
            }
        }
    }
}