import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (N-- > 0) {
            final int X = Integer.parseInt(br.readLine());
            if (X > 0) {
                pq.add(X);
            } else {
                sb.append(pq.size() > 0 ? pq.poll() : "0").append("\n");
            }
        }

        // Output
        System.out.println(sb);
    }
}