import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        Arrays.sort(P);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; --i) {
            if (i % 2 == 0)
                deque.addLast(P[i]);
            else
                deque.push(P[i]);
        }

        int sum = 0;
        int first = deque.peek();
        sb.append(first).append(" ");
        for (int i = 0; i < N - 1; ++i) {
            int cur = deque.pop();
            int next = deque.peek();

            sum += cur * next;

            sb.append(next).append(" ");
        }
        sum += first * deque.pop();

        // Output
        System.out.println(sum);
        System.out.println(sb);
    }
}