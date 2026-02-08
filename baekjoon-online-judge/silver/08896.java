import java.io.*;
import java.util.*;

public class Main {
    static char[][] info;
    static char[] simulationResult = {'P', 'R', 'S'};

    private static int[] getEnableCheckArr(boolean[] isAlive, int K) {
        int[] enable = {0, 0, 0};
        final int N = isAlive.length;
        for (int i = 0; i < N; ++i) {
            if (!isAlive[i]) {
                continue;
            }
            switch (info[i][K]) {
                case 'R':
                    enable[0] = 1;
                    break;
                case 'S':
                    enable[1] = 1;
                    break;
                case 'P':
                    enable[2] = 1;
                    break;
            }
        }
        return enable;
    }
    private static char getLoseChar(int[] enable) {
        for (int i = 0; i < 3; ++i) {
            if (enable[i] == 0) {
                return simulationResult[i];
            }
        }
        return 'X';
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            final int N = Integer.parseInt(br.readLine());
            info = new char[N][];
            for (int i = 0; i < N; ++i) {
                info[i] = br.readLine().toCharArray();
            }

            // Solve
            boolean[] isAlive = new boolean[N];
            Arrays.fill(isAlive, true);

            final int K = info[0].length;
            for (int k = 0; k < K; ++k) {
                int[] enable = getEnableCheckArr(isAlive, k);
                if (enable[0] + enable[1] + enable[2] != 2) {
                    continue;
                }
                final char loseChar = getLoseChar(enable);

                for (int i = 0; i < N; ++i) {
                    if (info[i][k] == loseChar) {
                        isAlive[i] = false;
                    }
                }
            }

            int idx = -1, cnt = 0;
            for (int i = 0; i < N; ++i) {
                if (isAlive[i]) {
                    ++cnt;
                    idx = i;
                }
            }
            sb.append(cnt != 1 ? 0 : idx + 1).append("\n");
        }

        // Output
        System.out.print(sb);
    }
}