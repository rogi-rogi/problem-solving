import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            line = br.readLine();
            
            // Solve
            char type = line.charAt(0);
            switch (type) {
                case '1' :
                    stack.push(line.substring(2));
                    break;
                case '2' :
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                case '3' :
                    sb.append(stack.size()).append("\n");
                    break;
                case '4' :
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case '5' :
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }

        // Output
        System.out.println(sb);
    }
}
