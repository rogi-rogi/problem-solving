import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            A.add(Integer.parseInt(br.readLine()));
        }

        // Solve
        PriorityQueue<Integer> pq = new PriorityQueue<>(A);
        int res = 0, newCard;
        while (pq.size() > 1) {
            newCard = pq.poll() + pq.poll();
            res += newCard;
            pq.add(newCard);
        }

        // Output
        System.out.println(res);
    }
}