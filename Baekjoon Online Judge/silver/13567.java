import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] D = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curDir = 0, curX = 0, curY = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            final int d = Integer.parseInt(st.nextToken());

            // Solve
            switch (type) {
                case "MOVE":
                    curX += d*D[curDir][0];
                    curY += d*D[curDir][1];
                    break;
                case "TURN":
                    curDir = (curDir + 4 + (d == 0 ? 1 : -1)) % 4;
                    break;
            }
            if (curX < 0 || curY < 0 || curX >= M || curY >= M) {
                System.out.println(-1);
                return;
            }
        }
        // Output
        System.out.println(curY + " " + curX);

    }
}