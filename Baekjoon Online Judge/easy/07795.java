import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        int N, M;
        int[] A, B;
        String[] input;
        while (T-- > 0) {
            input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Solve
            Arrays.sort(B);
            int res = 0;
            for (int a : A) {
                int s = 0, e = M - 1, mid, temp = -1;
                while (s <= e) {
                    mid = (s + e) >> 1;
                    if (a <= B[mid]) {
                        e = mid - 1;
                    } else {
                        s = mid + 1;
                        temp = mid;
                    }
                }
                res += temp + 1;
            }
            sb.append(res).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}
