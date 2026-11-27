import java.io.*;
import java.util.*;

public class Main {

    private static int solve(int level) {
        if (level == 300) return 1;
        if (level >= 275) return 2;
        if (level >= 250) return 3;
        return 4;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        br.readLine();
        int[] levels = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        StringBuilder sb = new StringBuilder();
        for (int level : levels) {
            sb.append(solve(level)).append(" ");
        }

        // Output
        System.out.println(sb);
    }
}