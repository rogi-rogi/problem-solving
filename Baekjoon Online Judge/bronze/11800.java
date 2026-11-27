import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] dice = {"", "Yakk", "Doh", "Seh", "Ghar", "Bang", "Sheesh"};
        String[] same = {"", "Habb Yakk", "Dobara", "Dousa", "Dorgy", "Dabash", "Dosh"};
        // Input
        final int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; ++i) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            final int a = Math.max(input[0], input[1]);
            final int b = Math.min(input[0], input[1]);

            // Solve
            if (a == b) {
                sb.append(String.format("Case %d: %s\n", i, same[a]));
            } else if (a == 6 && b == 5) {
                sb.append(String.format("Case %d: Sheesh Beesh\n", i));
            } else {
                sb.append(String.format("Case %d: %s %s\n", i, dice[a], dice[b]));
            }
        }

        // Output
        System.out.println(sb);
    }
}
