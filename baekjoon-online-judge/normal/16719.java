import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static char[] S;

    private static void recursive(int left, int right) {
        if (left > right)
            return;

        int idx = left;
        for (int i = left + 1; i <= right; ++i) {
            if (S[i] < S[idx]) {
                idx = i;
            }
        }

        visited[idx] = true;

        for (int i = 0; i < S.length; ++i) {
            if (visited[i]) {
                sb.append(S[i]);
            }
        }
        sb.append("\n");

        recursive(idx + 1, right);
        recursive(left, idx - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        S = br.readLine().toCharArray();

        // Solve
        visited = new boolean[S.length];
        recursive(0, S.length - 1);

        // Output
        System.out.println(sb);
    }
}