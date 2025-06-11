import java.io.*;
import java.util.*;

public class Main {
    private static long decimalArrToBit(int[] arr) {
        long res = 0;
        for (int i = 1; i < arr.length; ++i) {
            long bit = 1;
            while (--arr[i] > 0) {
                bit <<= 1;
            }
            res |= bit;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int N = Integer.parseInt(br.readLine());
        long[] bitA = new long[N];
        for (int i = 0; i < N; ++i) {
            int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bitA[i] = decimalArrToBit(A);
        }
        final int M = Integer.parseInt(br.readLine());
        long[] bitB = new long[M];
        for (int i = 0; i < M; ++i) {
            int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bitB[i] = decimalArrToBit(B);
        }

        // Solve
        for (long b : bitB) {
            int cnt = 0;
            for (long a : bitA) {
                if ((a & b) == a) {
                    ++cnt;
                }
            }
            sb.append(cnt).append("\n");
        }

        // Output
        System.out.print(sb);
    }
}