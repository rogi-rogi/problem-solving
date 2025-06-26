import java.io.*;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Map<Integer, List<Integer>> cafe = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cafe.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            }

            // Solve
            for (List<Integer> yList : cafe.values()) {
                Collections.sort(yList);
            }

            List<Integer> sortedX = new ArrayList<>(cafe.keySet());
            Collections.sort(sortedX);

            List<Point> result = new ArrayList<>();
            int prevY = 0;

            for (int curX : sortedX) {
                List<Integer> yList = cafe.get(curX);
                if (yList.get(0) != prevY) {
                    Collections.reverse(yList);
                }
                for (int y : yList) {
                    result.add(new Point(curX, y));
                }
                prevY = yList.get(yList.size() - 1);
            }

            // Output
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M; i++) {
                int k = Integer.parseInt(st.nextToken()) - 1;
                Point p = result.get(k);
                sb.append(p.x).append(" ").append(p.y).append("\n");
            }
        }

        System.out.print(sb);
    }
}
