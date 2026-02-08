import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Deque<Character> stack = new ArrayDeque<>();

        // Input
        line = br.readLine();

        // Solve
        final int SIZE = line.length();
        int score = 0, wrapper = 1;
        for (int i = 0; i < SIZE; ++i) {
            if (line.charAt(i) == '(' || line.charAt(i) == '[') {
                stack.push(line.charAt(i));
                wrapper *= (line.charAt(i) == '(' ? 2 : 3);
            } else {
                if (stack.isEmpty() || !isPair(stack.peek(), line.charAt(i))) {
                    score = 0;
                    break;
                }
                stack.pop();
                if (line.charAt(i - 1) == '(' || line.charAt(i - 1) == '[')
                    score += wrapper;
                wrapper /= (line.charAt(i) == ')' ? 2 : 3);
            }
        }
        if (!stack.isEmpty()) score = 0;

        // Output
        System.out.println(score);
    }
    private static boolean isPair(char left, char right) {
        return (left == '(' && right == ')' || left == '[' && right == ']' );
    }
}
