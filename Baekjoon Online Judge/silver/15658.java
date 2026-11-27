import java.io.*;
import java.util.*;

public class Main {
    static int[] A, OP;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    private static void bt(int temp, int nextIdx) {
        if (nextIdx == A.length) {
            max = Math.max(max, temp);
            min = Math.min(min, temp);
            return;
        }
        for (int i = 0; i < 4; ++i) {
            if (OP[i] > 0) {
                --OP[i];
                switch (i) {
                    case 0:
                        bt(temp + A[nextIdx], nextIdx + 1);
                        break;
                    case 1:
                        bt(temp - A[nextIdx], nextIdx + 1);
                        break;
                    case 2:
                        bt(temp * A[nextIdx], nextIdx + 1);
                        break;
                    case 3:
                        bt(temp / A[nextIdx], nextIdx + 1);
                        break;
                }
                ++OP[i];
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        br.readLine();
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        OP = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        bt(A[0], 1);

        // Output
        System.out.println(max);
        System.out.println(min);
    }
}