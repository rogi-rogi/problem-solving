import java.io.*;

public class Main {
    private static boolean isSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);
        int[][] A = new int[N][M];
        for (int i = 0; i < N; ++i) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; ++j) {
                A[i][j] = line[j] - '0';
            }
        }

        // Solve
        int res = -1;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                for (int dx = -N; dx < N; ++dx) {
                    for (int dy = -M; dy < M; ++dy) {
                        if (dx != 0 || dy != 0) {
                            int x = i;
                            int y = j;
                            int num = 0;
                            while (x >= 0 && x < N && y >= 0 && y < M) {
                                num = num * 10 + A[x][y];
                                if (isSquare(num)) {
                                    res = Math.max(res, num);
                                }
                                x += dx;
                                y += dy;
                            }
                        }
                    }
                }
            }
        }

        // Output
        System.out.println(res);
    }
}