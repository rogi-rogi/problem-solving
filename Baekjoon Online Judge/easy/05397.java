import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        Deque<Character> lStack = new ArrayDeque<>();
        Deque<Character> rStack = new ArrayDeque<>();

        // Input
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            line = br.readLine();
            int SIZE = line.length();

            // Solve
            for (int i = 0; i < SIZE; ++i) {
                switch (line.charAt(i)) {
                    case '<' :
                        if (!lStack.isEmpty()) rStack.push(lStack.pollLast());
                        break;
                    case '>' :
                        if (!rStack.isEmpty()) lStack.add(rStack.pop());
                        break;
                    case '-' :
                        if (!lStack.isEmpty()) lStack.pollLast();
                        break;
                    default:
                        lStack.add(line.charAt(i));
                }
            }

            while (!lStack.isEmpty()) sb.append(lStack.pop());
            while (!rStack.isEmpty()) sb.append(rStack.pop());
            sb.append("\n");
        }

        // Output
        System.out.println(sb);
    }
}
