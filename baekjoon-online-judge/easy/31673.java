import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        long[] V = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        // Solve
        Arrays.sort(V);
        long sum = 0;
        for (long v : V) {
            sum += v;
        }
        long cur = 0;
        int idx = N - 1;
        while (cur * 2 <= sum) {
            cur += V[idx--];
        }

        // Output
        System.out.print(M / (N - idx));
    }
}