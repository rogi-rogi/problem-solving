import java.io.*;

public class Main {

    private static String solve(int N, char[] A) {
        for (int L = 1; L <= 18; L++) {
            if (L > N + 1) break;

            int SIZE = 1 << (L - 1);
            byte[] seen = new byte[SIZE];
            int mask = (1 << L) - 1;

            int val = 0;
            for (int i = 0; i < N; ++i) {
                val = ((val << 1) & mask) | (A[i] - '0');

                if (i >= L - 1) {
                    int start = i - L + 1;
                    if (A[start] == '0')
                        continue;
                    int idx = val - (1 << (L - 1));
                    if (0 <= idx && idx < SIZE) {
                        seen[idx] = 1;
                    }
                }
            }

            for (int i = 0; i < SIZE; ++i) {
                if (seen[i] == 0) {
                    if (L == 1) {
                        return "1";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append('1');
                    String tail = Integer.toBinaryString(i);
                    while (tail.length() < L - 1) {
                        tail = "0" + tail;
                    }
                    sb.append(tail);
                    return sb.toString();
                }
            }
        }
        return "1";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        char[] A = br.readLine().toCharArray();

        // Solve & Output
        System.out.println(solve(N, A));
    }
}