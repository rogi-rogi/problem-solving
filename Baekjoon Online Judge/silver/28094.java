import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> P;
    static int N;
    static boolean[] visited;
    static int[] current;
    static int[][] score;

    private static void permutation(int depth) {
        if (depth == N) {
            P.add(current.clone());
            return;
        }
        for (int i = 1; i <= N; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                current[depth] = i;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            final int M = Integer.parseInt(st.nextToken());

            score = new int[N + 1][N + 1];
            for (int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine());
                final int V = Integer.parseInt(st.nextToken());
                final int A = Integer.parseInt(st.nextToken());
                final int B = Integer.parseInt(st.nextToken());
                score[A][B] += V;
            }

            // Solve
            P = new ArrayList<>();
            visited = new boolean[N + 1];
            current = new int[N];
            permutation(0);

            int max = 0, same = 0;
            // O(N^2 * N! = 81 * 9! = 29,393,280)
            for (int[] p : P) {
                int sum = 0;
                for (int a = 0; a < N; ++a) {
                    for (int b = a + 1; b < N; ++b) {
                        sum += score[p[a]][p[b]];
                    }
                }
                if (sum > max) {
                    max = sum;
                    same = 1;
                } else if (sum == max) {
                    ++same;
                }
            }
            sb.append(max).append(" ").append(same).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}