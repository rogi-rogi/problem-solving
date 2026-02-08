import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> xCnt = new HashMap<>();
        Map<Integer, Integer> yCnt = new HashMap<>();
        int[] x = new int[N];
        int[] y = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());

            // Solve
            xCnt.put(x[i], xCnt.getOrDefault(x[i], 0) + 1);
            yCnt.put(y[i], yCnt.getOrDefault(y[i], 0) + 1);
        }
        long cnt = 0;
        for (int i = 0; i < N; ++i) {
            cnt += (long) (xCnt.get(x[i]) - 1) * (yCnt.get(y[i]) - 1);
        }

        // Output
        System.out.println(cnt);
    }
}