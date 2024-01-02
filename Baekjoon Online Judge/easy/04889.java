import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        // Input
        for (int i = 1; ; ++i) {
            line = br.readLine();
            if (line.charAt(0) == '-') break;

            // Solve
            for (Character c : line.toCharArray()) {
                if (!stack.isEmpty() && stack.peekLast() == '{' && c == '}') {
                    stack.pollLast();
                } else stack.add(c);
            }

            int cnt = 0;
            char L, R;
            while (!stack.isEmpty()) {
                L = stack.pop();
                R = stack.pop();
                cnt += (L == '}' && R == '{') ? 2 : 1;
            }
            sb.append(i).append(". ").append(cnt).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}
