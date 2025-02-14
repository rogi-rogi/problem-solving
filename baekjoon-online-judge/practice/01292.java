import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());

        // Solve
        int idx = 1;
        int n = 1, k = 1, res = 0;
        while (idx <= B) {
            while (k-- > 0) {
                if (idx >= A && idx <= B) {
                    res += n;
                }
                ++idx;
            }
            k = ++n;
        }

        // Output
        System.out.println(res);
    }
}
