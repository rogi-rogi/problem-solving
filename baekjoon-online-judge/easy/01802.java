import java.io.*;

public class Main {
    private static boolean divide(char[] A, int start, int end) {
        if (start == end) {
            return true;
        }
        final int mid = (start + end) >> 1;
        for (int i = start; i < mid; ++i) {
            if (A[i] == A[end - i]) {
                return false;
            }
        }
        return divide(A, start, mid - 1) && divide(A, mid + 1, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] A = br.readLine().toCharArray();

            // Solve
            sb.append(divide(A, 0, A.length - 1) ? "YES" : "NO").append("\n");
        }

        // Output
        System.out.println(sb);
    }
}