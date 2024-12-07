import java.io.*;
import java.util.*;

public class Main {
    static int[] count = new int[10];
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int res = 0;
        if (N == 1) {
            res = 1;
        } else if (N == 2) {
            res = S[0] == S[1] ? 2 : 1;
        } else {
            int left = 0, right = 0;
            int distinct = 0;
            while (left < N && right < N) {
                ++count[S[right]];
                if (count[S[right]] == 1) {
                    ++distinct;
                }
                while (distinct > 2) {
                    --count[S[left++]];
                    if (count[S[left]] == 0) {
                        --distinct;
                    }
                }
                res = Math.max(res, right - left + 1);
                ++right;
            }
        }

        // Output
        System.out.println(res);
    }
}
