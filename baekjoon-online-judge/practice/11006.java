import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int N = Integer.parseInt(st.nextToken());
            final int M = Integer.parseInt(st.nextToken());

            // Solve
            sb.append(String.format("%d %d\n", M - (N - M), N - M));
        }

        // Output
        System.out.println(sb);
    }
}