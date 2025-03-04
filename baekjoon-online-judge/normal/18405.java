import java.io.*;
import java.util.*;

public class Main {
    static int N, K, X, Y, S;
    static int[][] A;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    private static void bfs() {
        if (A[X - 1][Y - 1] != 0)
            return;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (A[i][j] > 0) {
                    list.add(new int[]{i, j, 0, A[i][j]});
                }
            }
        }
        list.sort(Comparator.comparingInt(a -> a[3]));

        Deque<int[]> queue = new ArrayDeque<>(list);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            final int x = cur[0];
            final int y = cur[1];
            final int time = cur[2];

            for (int d = 0; d < 4; ++d) {
                final int nx = x + dx[d];
                final int ny = y + dy[d];
                if (isValid(nx, ny) && A[nx][ny] == 0) {
                    if (time + 1 <= S) {
                        A[nx][ny] = A[x][y];
                        queue.add(new int[]{nx, ny, time + 1});
                    }
                }
            }
        }
    }
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        K = input[1];
        A = new int[N][];
        for (int i = 0; i < N; i++) {
            A[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        S = input[0];
        X = input[1];
        Y = input[2];

        // Solve
        bfs();

        // Output
        System.out.println(A[X - 1][Y - 1]);
    }
}