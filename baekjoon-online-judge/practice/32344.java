import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int R = Integer.parseInt(input[0]);
        final int C = Integer.parseInt(input[1]);
        final int N = Integer.parseInt(br.readLine());

        int[] minRow = new int[N + 1];
        int[] maxRow = new int[N + 1];
        int[] minCol = new int[N + 1];
        int[] maxCol = new int[N + 1];
        Arrays.fill(minRow, R + 1);
        Arrays.fill(minCol, C + 1);
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int id = Integer.parseInt(input[0]);
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);

            // Solve
            minRow[id] = Math.min(minRow[id], row);
            maxRow[id] = Math.max(maxRow[id], row);
            minCol[id] = Math.min(minCol[id], col);
            maxCol[id] = Math.max(maxCol[id], col);
        }

        long resId = -1, resArea = -1;
        for (int id = 1; id <= N; id++) {
            if(maxRow[id] == 0) continue;
            final long area = (long)(maxRow[id] - minRow[id] + 1) * (maxCol[id] - minCol[id] + 1);
            if (area > resArea || (area == resArea && id < resId)) {
                resArea = area;
                resId = id;
            }
        }

        // Output
        System.out.println(resId + " " + resArea);
    }
}