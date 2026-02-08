import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] A;
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
    /*
    0: x좌표가 증가하는 방향 (→)
    1: y좌표가 감소하는 방향 (↑)
    2: x좌표가 감소하는 방향 (←)
    3: y좌표가 증가하는 방향 (↓)
     */
    private static void simulation(int x, int y, int d, int g) {
        A[x][y] = true;
        List<Integer> path = new ArrayList<>(List.of(d));
        for (int i = 0; i < g; ++i) {
            final int G = (int) Math.pow(2, i);
            for (int j = 0; j < G; ++j) {
                path.add((path.get(G - j - 1) + 1) % 4);
            }
        }
        for (int dir : path) {
            final int nx = x + dx[dir];
            final int ny = y + dy[dir];
            if (isValid(nx, ny)) {
                if (!A[nx][ny])
                    A[nx][ny] = true;
                x = nx;
                y = ny;
            }

        }
    }
    private static boolean isValid(int x, int y) {
        return x >= 0 && x <= 100 && y >= 0 && y <= 100;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = new boolean[101][101];

        // Input
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            final int x = input[0], y = input[1];
            final int d = input[2], g = input[3];

            // Solve
            simulation(y, x, d, g);
        }

        int cnt = 0;
        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < 100; ++j) {
                if (A[i][j] && A[i + 1][j] && A[i][j + 1] && A[i + 1][j + 1]) {
                    ++cnt;
                }
            }
        }

        // Output
        System.out.println(cnt);
    }
}