import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] L = new int[N];
        int[] R = new int[N];

        long lSum = 0, rSum = 0;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(st.nextToken());
            R[i] = Integer.parseInt(st.nextToken());
            lSum += L[i];
            rSum += R[i];
        }

        // Solve
        long part1_LSum = 0;
        long part1_RSum = 0;
        int cnt = 0;

        for (int i = 0; i < N - 1; ++i) {
            part1_LSum += L[i];
            part1_RSum += R[i];
            long part2_LSum = lSum - part1_LSum;
            long part2_RSum = rSum - part1_RSum;

            if (part1_LSum <= part2_RSum && part2_LSum <= part1_RSum) {
                ++cnt;
            }
        }

        // Output
        System.out.println(cnt);
    }
}