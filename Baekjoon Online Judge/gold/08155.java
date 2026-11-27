import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int h = Integer.parseInt(st.nextToken());

            // Solve
            while (!stack.isEmpty() && stack.peek() > h) {
                stack.pop();
            }

            if (stack.isEmpty() || stack.peek() < h) {
                ++result;
                stack.push(h);
            }
        }

        // Output
        System.out.println(result);
    }
}
