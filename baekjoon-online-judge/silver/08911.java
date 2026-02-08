import java.io.*;


public class Main {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] commands  = br.readLine().toCharArray();

            // Solve
            int x = 0, y = 0;
            int dir = 0;
            int minX = 0, minY = 0, maxX = 0, maxY = 0;

            for (char command : commands) {
                switch (command) {
                    case 'F':
                        x += dx[dir];
                        y += dy[dir];
                        break;
                    case 'B':
                        x -= dx[dir];
                        y -= dy[dir];
                        break;
                    case 'L':
                        dir = (dir + 1) % 4;
                        break;
                    case 'R':
                        dir = (dir + 3) % 4;
                        break;
                }
                maxX = Math.max(maxX, x);
                minX = Math.min(minX, x);
                maxY = Math.max(maxY, y);
                minY = Math.min(minY, y);
            }

            int area = (maxX - minX) * (maxY - minY);
            sb.append(area).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}