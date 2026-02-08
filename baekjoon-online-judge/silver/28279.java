import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());
        Deque<String> deque = new ArrayDeque<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            // Solve
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    deque.addFirst(st.nextToken());
                    break;
                case 2:
                    deque.addLast(st.nextToken());
                    break;
                case 3:
                    sb.append(deque.isEmpty() ? "-1" : deque.removeFirst()).append("\n");
                    break;
                case 4:
                    sb.append(deque.isEmpty() ? "-1" : deque.removeLast()).append("\n");
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    sb.append(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case 7:
                    sb.append(deque.isEmpty() ? "-1" : deque.peek()).append("\n");
                    break;
                case 8:
                    sb.append(deque.isEmpty() ? "-1" : deque.peekLast()).append("\n");
                    break;
            }
        }

        // Output
        System.out.println(sb);
    }
}