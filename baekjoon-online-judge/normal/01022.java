import java.io.*;
import java.util.*;

public class Main {
    private static int getMaxValue(int level) {
        int value = 2 * level + 1;
        return value * value;
    }

    private static int getValue(int y, int x) {
        if (x == 0 && y == 0) return 1;

        int level = Math.max(Math.abs(x), Math.abs(y));
        int maxValue = getMaxValue(level);
        final int diff = 2 * level;

        if (y == level)
            return maxValue - (level - x);

        maxValue -= diff;
        if (-x == level)
            return maxValue - (level - y);

        maxValue -= diff;
        if (-y == level)
            return maxValue - (level + x);

        maxValue -= diff;
        return maxValue - (level + y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] in = br.readLine().split(" ");

        final int r1 = Integer.parseInt(in[0]);
        final int c1 = Integer.parseInt(in[1]);
        final int r2 = Integer.parseInt(in[2]);
        final int c2 = Integer.parseInt(in[3]);

        // Solve
        int maxValue = 0;
        int[][] result = new int[r2 - r1 + 1][c2 - c1 + 1];
        for (int i = r1; i <= r2; ++i) {
            for (int j = c1; j <= c2; ++j) {
                result[i - r1][j - c1] = getValue(i, j);
                maxValue = Math.max(maxValue, result[i - r1][j - c1]);
            }
        }
        final int maxValueLength = String.valueOf(maxValue).length();


        // Output
        StringBuilder sb = new StringBuilder();
        for (int i = r1; i <= r2; ++i) {
            for (int j = c1; j <= c2; ++j) {
                sb.append(String.format("%" + (maxValueLength + (j != c1 ? 1 : 0)) + "d", result[i - r1][j - c1]));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}