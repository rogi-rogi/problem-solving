import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        // Solve
        for (int i = 0; i < N; ++i) {
            cnt += Integer.parseInt(br.readLine());
        }

        // Output
        System.out.println(cnt > (N >> 1) ? "Junhee is cute!" : "Junhee is not cute!");
    }
}