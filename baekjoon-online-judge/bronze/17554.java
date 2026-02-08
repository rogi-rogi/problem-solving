import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        boolean[] light = new boolean[N];
        Arrays.fill(light, true);

        int res = 0;
        while (K-- > 0) {
            final int i = Integer.parseInt(br.readLine());

            // Solve
            int cur = -1;
            while ((cur += i) < N) light[cur] = !light[cur];
            int sum = 0;
            for (boolean b : light) {
                if (!b) ++sum;
            }
            res = Math.max(res, sum);
        }

        // Output
        System.out.println(res);
    }
}
