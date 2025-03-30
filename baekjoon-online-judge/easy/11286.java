import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        PriorityQueue<Integer[]> heap = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
                    return o1[0].compareTo(o2[0]);
                }
        );
        while (N-- > 0) {
            final int X = Integer.parseInt(br.readLine());
            if (X == 0) {
                sb.append(heap.isEmpty() ? "0" : heap.remove()[1]).append("\n");
            } else {
                heap.offer(new Integer[]{Math.abs(X), X});
            }
        }

        // Output
        System.out.println(sb);
    }
}