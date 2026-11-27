import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int T = Integer.parseInt(st.nextToken());
        final int P = Integer.parseInt(st.nextToken());
        
        // Solve
        int res = 0;
        for (int num : S) {
            if (num % T == 0) {
                res += num / T;
            } else {
                res += num / T + 1;
            }
        }

        // Output
        System.out.printf("%d\n%d %d%n", res, N / P, N % P);
    }
}
