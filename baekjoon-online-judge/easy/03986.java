import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Deque<Character> stack = new ArrayDeque<>();

        // Input
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (N-- > 0) {
            input = br.readLine();
            
            // Solve
            for (char word : input.toCharArray()) {
                if (!stack.isEmpty() && stack.peek().equals(word)) {
                    stack.pop();
                } else {
                    stack.push(word);
                }
            }
            /*
            final int SIZE = input.length();
            for (int i = 0; i < SIZE; ++i) {
                if (!stack.isEmpty() && stack.peek().equals(input.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(input.charAt(i));
                }
            }
            */
            if (stack.isEmpty()) ++cnt;
            else stack.clear();
        }

        // Output
        System.out.println(cnt);
    }
}
