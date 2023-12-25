import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<String> queuestack = new ArrayDeque<>();

        // Input
        int N = Integer.parseInt(br.readLine());
        boolean[] isQueue = new boolean[N];
        String type = br.readLine();
        String[] init = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            if (type.charAt(i*2) == '0') {
                queuestack.push(init[i]);
            }
        }
        int M = Integer.parseInt(br.readLine());

        // Solve
        for (String c : br.readLine().split(" ")) {
            queuestack.add(c);
            sb.append(queuestack.pop()).append(" ");
        }

        // Output
        System.out.println(sb);
    }
}
