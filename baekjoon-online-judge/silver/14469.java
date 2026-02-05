import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        int[][] cows = new int[N][2];
        for (int i = 0; i < N; ++i) {
            String[] in = br.readLine().split(" ");
            cows[i][0] = Integer.parseInt(in[0]);
            cows[i][1] = Integer.parseInt(in[1]);
        }

        // Solve
        Arrays.sort(cows, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int time = 0, idx = 0;
        while (true) {
            if (time < cows[idx][0]) {
                time = cows[idx][0];
            }
            time += cows[idx][1];
            if (++idx == N) break;
        }

        // Output
        System.out.println(time);
    }
}