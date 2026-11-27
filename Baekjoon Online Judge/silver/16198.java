import java.io.*;
import java.util.*;

public class Main {
    private static int res = 0;

    private static void bt(ArrayList<Integer> W, int len, int sum_w) {
        if (len == 2) {
            res = Math.max(res, sum_w);
            return;
        }
        for (int i = 1; i < len - 1; ++i) {
            int mul_w = W.get(i - 1) * W.get(i + 1);
            int temp = W.get(i);
            W.remove(i);
            bt(W, len - 1, sum_w + mul_w);
            W.add(i, temp);
        }
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> W = new ArrayList<>();
        for (String w : br.readLine().split(" ")) {
            W.add(Integer.parseInt(w));
        }

        // Solve
        bt(W, N, 0);

        // Output
        System.out.println(res);
    }
}
