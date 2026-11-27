import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] speeds = new int[N];
        for (int i = 0; i < N; ++i) {
            speeds[i] = Integer.parseInt(br.readLine().split(" ")[1]);
        }

        // Solve
        int cnt = 1, curSpeed = speeds[N - 1];
        for (int i = N - 2; i >= 0; --i) {
            if (speeds[i] <= curSpeed) {
                ++cnt;
                curSpeed = speeds[i];
            }
        }

        // Output
        System.out.println(cnt);
    }
}
