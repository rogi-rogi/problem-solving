import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        Deque<Integer>[] stackList = new Deque[7];
        for (int i = 0; i < 7; ++i)
            stackList[i] = new ArrayDeque<>();

        // Input
        line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int P = Integer.parseInt(line[1]);
      
        // Solve
        int cnt = 0;
        while (N-- > 0) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            while (!stackList[a].isEmpty() && stackList[a].peek() > b) {
                stackList[a].pop();
                ++cnt;
            }
            if (stackList[a].isEmpty() || stackList[a].peek() < b) {
                stackList[a].push(b);
                ++cnt;
            }
        }

        // Output
        System.out.println(cnt);
    }
}
