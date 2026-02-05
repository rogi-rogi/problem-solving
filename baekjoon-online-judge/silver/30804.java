import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        int[] S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int[] cnt = new int[10];
        int res = 0;
        int l = 0, r = 0;
        int distinctCount = 0;
        while (l < N && r < N) {
            if (++cnt[S[r]] == 1) {
                ++distinctCount;
            }
            while (distinctCount > 2) {
                if (--cnt[S[l++]] == 0) {
                    --distinctCount;
                }
            }
            res = Math.max(res, r - l);
            ++r;
        }

        // Output
        System.out.println(res + 1);
    }
}