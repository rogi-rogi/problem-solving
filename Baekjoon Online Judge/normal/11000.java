import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[][] room_list = new int[N][2];
        for (int i = 0; i < N; ++i) {
            room_list[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // Solve
        Arrays.sort(room_list, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(List.of(0));
        for (int[] room: room_list) {
            final int s = room[0];
            final int e = room[1];
            pq.add(e);
            if (pq.peek() <= s) {
                pq.poll();
            }
        }

        // Output
        System.out.println(pq.size());
    }
}
