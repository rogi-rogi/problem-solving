import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> waitStack = new ArrayDeque<>();

        // Input
        int N = Integer.parseInt(br.readLine());
        for (String num : br.readLine().split(" "))
            stack.add(Integer.parseInt(num));

        // Solve
        int curNum = 1;
        while (!stack.isEmpty()) {
            if (stack.peek() == curNum) {
                stack.pop();
                ++curNum;
            } else if (!waitStack.isEmpty() && waitStack.peek() == curNum){
                waitStack.pop();
                ++curNum;
            } else {
                waitStack.push(stack.pop());
            }
        }

        String res = "Nice";
        for (; curNum <= N; ++curNum) {
            if (waitStack.pop() != curNum) {
                res = "Sad";
                break;
            }
        }

        // Output
        System.out.println(res);
    }
}
