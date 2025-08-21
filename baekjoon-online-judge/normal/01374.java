import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][2];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        // Solve
        Arrays.sort(lectures, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            List.of(lectures[0][1])
        );

        for (int i = 1; i < N; ++i) {
            final int start = lectures[i][0];
            final int end = lectures[i][1];

            final int earlyEnd = pq.peek();
            if (start >= earlyEnd) {
                pq.poll();
            }
            pq.add(end);
        }

        // Output
        System.out.println(pq.size());
    }
}