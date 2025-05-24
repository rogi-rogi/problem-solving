import java.io.*;
import java.util.*;

public class Main {
    private static boolean solve(int X, int Y, int[] Z, int idx, int M, int N) {
        int temp = 0;
        for (int i = idx; i < idx + M; ++i) {
            temp = temp * 10 + Z[i % N];
        }
        return X <= temp && temp <= Y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int N = Integer.parseInt(st.nextToken());
            final int M = Integer.parseInt(st.nextToken());
            int X = 0, Y = 0;
            for (int x : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
                X = X * 10 + x;
            }
            for (int y : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
                Y = Y * 10 + y;
            }
            int[] Z = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Solve
            int cnt = 0;
            for (int i = 0; i < N; ++i) {
                if (solve(X, Y, Z, i, M, N))
                    ++cnt;
            }
            sb.append(cnt).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}