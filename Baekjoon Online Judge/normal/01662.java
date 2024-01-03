import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S;
        Deque<String> stack = new ArrayDeque<>();

        // Input
        S = br.readLine().split("");

        // Solve
        int K, lenQ;
        String cur;
        final int SIZE = S.length;
        for (int i = 0; i < SIZE; ++i) {
            if (S[i].equals(")")) {
                lenQ = 0;
                while (!stack.isEmpty()) {
                    cur = stack.pop();
                    if (cur.equals("(")) break;
                    else if (!cur.equals("|")) ++lenQ;
                    else lenQ += Integer.parseInt(stack.pop());
                }
                K = Integer.parseInt(stack.pop());
                // K * lenQ = K(Q) len
                stack.push(String.valueOf(K * lenQ));
                stack.push("|");
            } else stack.push(S[i]);
        }
        int res = 0;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (!cur.equals("|")) ++res;
            else res += Integer.parseInt(stack.pop());
        }

        // Output
        System.out.println(res);
    }
}
