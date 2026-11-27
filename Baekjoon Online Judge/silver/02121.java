import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        final int A = Integer.parseInt(input[0]);
        final int B = Integer.parseInt(input[1]);

        Set<Point> set = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            input = br.readLine().split(" ");
            final int x = Integer.parseInt(input[0]);
            final int y = Integer.parseInt(input[1]);

            // Solve
            set.add(new Point(x, y));
        }
        long cnt = 0;
        for (Point p : set) {
            if (set.contains(new Point(p.x + A, p.y)) &&
                    set.contains(new Point(p.x, p.y + B)) &&
                    set.contains(new Point(p.x + A, p.y + B))) {
                ++cnt;
            }
        }

        // Output
        System.out.println(cnt);
    }
}