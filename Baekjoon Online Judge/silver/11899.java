import java.io.*;
import java.util.*;

public class Main {
    private static final char LEFT = '(', RIGHT = ')';

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> stack = new ArrayDeque<>();

        // Input
        char[] S = br.readLine().toCharArray();

        // Solve
        int cnt = 0;
        for (char cur : S) {
            if (cur == RIGHT) {
                if (!stack.isEmpty() && stack.peek() == LEFT) {
                    stack.pop();
                } else ++cnt;
            } else stack.push(cur);
        }

        // Output
        System.out.println(cnt + stack.size());
    }
}
